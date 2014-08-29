-- Aug 27, 2014 11:55:59 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
CREATE TABLE HR_IGConcept (AD_Client_ID NUMERIC(10) NOT NULL, AD_Org_ID NUMERIC(10) NOT NULL, Created TIMESTAMP NOT NULL, CreatedBy NUMERIC(10) NOT NULL, HR_Concept_ID NUMERIC(10) DEFAULT NULL , HR_IncidenceGroup_ID NUMERIC(10) DEFAULT NULL , IsActive CHAR(1) DEFAULT 'Y' CHECK (IsActive IN ('Y','N')) NOT NULL, Updated TIMESTAMP NOT NULL, UpdatedBy NUMERIC(10) NOT NULL)
;

