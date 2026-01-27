create database SafeMove

/* ===============================
   1. ACCOUNT (LOGIN + ROLE)
   =============================== */
CREATE TABLE Account (
    account_id INT IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    [password] VARCHAR(255) NOT NULL,
    [role] VARCHAR(20) NOT NULL
        CHECK (role IN ('ADMIN', 'STAFF', 'CUSTOMER')),
    [status] VARCHAR(20) DEFAULT 'ACTIVE'
);

/* ===============================
   2. CUSTOMER (BUSINESS INFO)
   =============================== */
CREATE TABLE Customer (
    customer_id INT IDENTITY PRIMARY KEY,
    account_id INT NOT NULL UNIQUE,
    full_name NVARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100),

    CONSTRAINT FK_Customer_Account
        FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

/* ===============================
   3. STAFF (REAL-WORLD EMPLOYEE)
   =============================== */

CREATE TABLE Staff(
    staff_id INT PRIMARY KEY IDENTITY,
    full_name NVARCHAR(100),
    phone VARCHAR(20),
    position NVARCHAR(50)
);

CREATE TABLE Staff_Account (
    account_id INT PRIMARY KEY,
    staff_id INT UNIQUE NOT NULL,

    CONSTRAINT FK_StaffAccount_Account
        FOREIGN KEY (account_id) REFERENCES Account(account_id),

    CONSTRAINT FK_StaffAccount_Staff
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);

/* ===============================
   4. VEHICLE TYPE
   =============================== */
CREATE TABLE Vehicle_Type (
    vehicle_type_id INT IDENTITY PRIMARY KEY,
    [name] NVARCHAR(50) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    [description] NVARCHAR(255)
);

/* ===============================
   5. VEHICLE
   - 1 vehicle
   - 1 leader staff quản lý
   =============================== */
CREATE TABLE Vehicle (
    vehicle_id INT IDENTITY PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL UNIQUE,
    vehicle_type_id INT NOT NULL,
    leader_staff_id INT NOT NULL,
    [status] VARCHAR(20) NOT NULL,

    CONSTRAINT FK_Vehicle_Type
        FOREIGN KEY (vehicle_type_id) REFERENCES Vehicle_Type(vehicle_type_id),

    CONSTRAINT FK_Vehicle_LeaderStaff
        FOREIGN KEY (leader_staff_id) REFERENCES Staff(staff_id)
);

/* ===============================
   6. SERVICE
   - 1 service ↔ 1 vehicle type
   =============================== */
CREATE TABLE Service (
    service_id INT IDENTITY PRIMARY KEY,
    vehicle_type_id INT NOT NULL UNIQUE,
    [service_name] NVARCHAR(100) NOT NULL,
    [description] NVARCHAR(255),
    base_price DECIMAL(12,2) NOT NULL,

    CONSTRAINT FK_Service_VehicleType
        FOREIGN KEY (vehicle_type_id) REFERENCES Vehicle_Type(vehicle_type_id)
);

/* ===============================
   7. PRICE TABLE (BY DISTANCE)
   =============================== */
CREATE TABLE Price_Table (
    price_id INT IDENTITY PRIMARY KEY,
    service_id INT NOT NULL,
    min_distance_km INT NOT NULL,
    max_distance_km INT NOT NULL,
    price_per_km DECIMAL(12,2) NOT NULL,

    CONSTRAINT FK_Price_Service
        FOREIGN KEY (service_id) REFERENCES Service(service_id),

    CONSTRAINT CK_Distance_Range
        CHECK (min_distance_km < max_distance_km)
);

/* ===============================
   8. SURVEY REQUEST
   =============================== */
CREATE TABLE Survey_Request (
    request_id INT IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    pickup_address NVARCHAR(255) NOT NULL,
    destination_address NVARCHAR(255) NOT NULL,
    [start_date] DATE NOT NULL,
    num_staff INT NOT NULL CHECK (num_staff > 0),
    estimated_price DECIMAL(12,2),
    estimated_distance_km INT,
    [status] VARCHAR(30) NOT NULL,
    created_date DATETIME DEFAULT GETDATE(),

    CONSTRAINT FK_Request_Customer
        FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),

    CONSTRAINT FK_Request_Service
        FOREIGN KEY (service_id) REFERENCES Service(service_id)
);

/* ===============================
   9. CONTRACT
   - 1 contract ↔ 1 survey
   =============================== */
CREATE TABLE Contract (
    contract_id INT IDENTITY PRIMARY KEY,
    request_id INT NOT NULL UNIQUE,
    num_staff INT NOT NULL CHECK (num_staff > 0),
    deposit_amount DECIMAL(12,2) NOT NULL CHECK (deposit_amount >= 0),
    total_amount DECIMAL(12,2) NOT NULL CHECK (total_amount >= 0),
    [start_date] DATE NOT NULL,
    end_date DATE NOT NULL,
    [status] VARCHAR(30) NOT NULL,
    vehicle_id INT NULL,

    CONSTRAINT FK_Contract_Request
        FOREIGN KEY (request_id) REFERENCES Survey_Request(request_id),

    CONSTRAINT FK_Contract_Vehicle
        FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id),

    CONSTRAINT CK_Contract_Date
        CHECK (end_date >= start_date)
);

/* ===============================
   10. CONTRACT - STAFF (N:N)
   =============================== */
CREATE TABLE Contract_Staff (
    contract_id INT NOT NULL,
    staff_id INT NOT NULL,

    PRIMARY KEY (contract_id, staff_id),

    CONSTRAINT FK_CS_Contract
        FOREIGN KEY (contract_id) REFERENCES Contract(contract_id),

    CONSTRAINT FK_CS_Staff
        FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);

/* ===============================
   11. DAMAGE REPORT
   =============================== */
CREATE TABLE Report_Damage (
    damage_id INT IDENTITY PRIMARY KEY,
    contract_id INT NOT NULL,
    responsible_staff_id INT NOT NULL,
    cause NVARCHAR(255) NOT NULL,
    [description] NVARCHAR(255),
    compensation DECIMAL(12,2) NOT NULL CHECK (compensation >= 0),

    CONSTRAINT FK_Damage_Contract
        FOREIGN KEY (contract_id) REFERENCES Contract(contract_id),

    CONSTRAINT FK_Damage_Staff
        FOREIGN KEY (responsible_staff_id) REFERENCES Staff(staff_id)
);
