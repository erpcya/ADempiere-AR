-- Aug 28, 2014 11:58:45 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
CREATE TABLE HR_JournalLine (AD_Client_ID NUMERIC(10) NOT NULL, AD_Org_ID NUMERIC(10) NOT NULL, Created TIMESTAMP NOT NULL, CreatedBy NUMERIC(10) NOT NULL, Description VARCHAR(255) DEFAULT NULL , EndTime TIMESTAMP DEFAULT NULL , HR_Concept_ID NUMERIC(10) NOT NULL, HR_Journal_ID NUMERIC(10) NOT NULL, HR_JournalLine_ID NUMERIC(10) DEFAULT NULL , IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, StartTime TIMESTAMP DEFAULT NULL , Updated TIMESTAMP NOT NULL, UpdatedBy NUMERIC(10) NOT NULL, CONSTRAINT HR_JournalLine_Key PRIMARY KEY (HR_JournalLine_ID))
;

