-- Aug 27, 2014 3:27:34 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsKey='Y', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:27:34','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000086
;

-- Aug 27, 2014 3:27:38 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_Journal MODIFY HR_Journal_ID NUMBER(10) DEFAULT NULL 
;

-- Aug 27, 2014 3:28:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsKey='Y', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:28:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000007
;

-- Aug 27, 2014 3:28:10 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_JournalLine MODIFY HR_JournalLine_ID NUMBER(10) DEFAULT NULL 
;

-- Aug 27, 2014 3:28:49 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='N',Updated=TO_DATE('2014-08-27 15:28:49','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000010
;

-- Aug 27, 2014 3:29:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET AD_Reference_ID=30,Updated=TO_DATE('2014-08-27 15:29:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000009
;

-- Aug 27, 2014 3:29:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_JournalLine MODIFY HR_Concept_ID NUMBER(10)
;

-- Aug 27, 2014 3:29:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_JournalLine MODIFY HR_Concept_ID NOT NULL
;

-- Aug 27, 2014 3:30:35 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsKey='Y', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:30:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000020
;

-- Aug 27, 2014 3:30:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:30:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000022
;

-- Aug 27, 2014 3:31:01 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:31:01','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000021
;

-- Aug 27, 2014 3:31:08 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_AttendanceRecord MODIFY T_DateTime DATE
;

-- Aug 27, 2014 3:31:08 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_AttendanceRecord MODIFY T_DateTime NOT NULL
;

-- Aug 27, 2014 3:31:21 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_AttendanceRecord MODIFY HR_Employee_ID NUMBER(10)
;

-- Aug 27, 2014 3:31:21 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_AttendanceRecord MODIFY HR_Employee_ID NOT NULL
;

-- Aug 27, 2014 3:31:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:31:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000031
;

-- Aug 27, 2014 3:32:08 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsKey='Y', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:32:08','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000030
;

-- Aug 27, 2014 3:32:09 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_Calendar MODIFY HR_Calendar_ID NUMBER(10) DEFAULT NULL 
;

-- Aug 27, 2014 3:32:27 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_Calendar MODIFY Name NVARCHAR2(60)
;

-- Aug 27, 2014 3:32:27 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_Calendar MODIFY Name NOT NULL
;

-- Aug 27, 2014 3:33:21 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsKey='Y', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:33:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000040
;

-- Aug 27, 2014 3:33:22 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_Day MODIFY HR_Day_ID NUMBER(10)
;

-- Aug 27, 2014 3:33:56 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='N', IsUpdateable='N',Updated=TO_DATE('2014-08-27 15:33:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000040
;

-- Aug 27, 2014 3:34:18 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:34:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000106
;

-- Aug 27, 2014 3:35:19 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET AD_Reference_ID=19,Updated=TO_DATE('2014-08-27 15:35:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000107
;

-- Aug 27, 2014 3:35:23 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IGConcept MODIFY HR_IncidenceGroup_ID NUMBER(10) DEFAULT NULL 
;

-- Aug 27, 2014 3:35:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IGConcept MODIFY HR_Concept_ID NUMBER(10)
;

-- Aug 27, 2014 3:35:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IGConcept MODIFY HR_Concept_ID NOT NULL
;

-- Aug 27, 2014 3:35:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IGConcept MODIFY HR_IncidenceGroup_ID NUMBER(10) DEFAULT NULL 
;

-- Aug 27, 2014 3:36:32 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:36:32','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000117
;

-- Aug 27, 2014 3:36:33 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IncidenceGroup MODIFY Value NVARCHAR2(60)
;

-- Aug 27, 2014 3:36:33 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IncidenceGroup MODIFY Value NOT NULL
;

-- Aug 27, 2014 3:36:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_DATE('2014-08-27 15:36:46','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=1000118
;

-- Aug 27, 2014 3:36:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IncidenceGroup MODIFY Name NVARCHAR2(60)
;

-- Aug 27, 2014 3:36:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE HR_IncidenceGroup MODIFY Name NOT NULL
;

-- Aug 27, 2014 3:40:31 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET AD_Reference_ID=30,Updated=TO_DATE('2014-08-27 15:40:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000014
;

