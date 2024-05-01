ALTER TABLE history_patients DROP CONSTRAINT IF EXISTS history_patients_patient_id_fkey;
DROP TABLE IF EXISTS history_patients;
DROP TABLE IF EXISTS patients;