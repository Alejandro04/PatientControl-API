CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    age INTEGER,
    phone VARCHAR
);

CREATE TABLE history_patients (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP,
    reason_consulting VARCHAR,
    details_consulting VARCHAR,
    patient_id BIGINT,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);