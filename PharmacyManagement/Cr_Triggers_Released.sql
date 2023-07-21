SET TERM OFF;
SET ECHO OFF;
SET DEFINE OFF;
SET SERVEROUTPUT ON;
SET TIMING ON;

SPOOL Cr_Triggers_Released.log;

SELECT INSTANCE_NAME, USER, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') START_TIME FROM v$instance;

Rem	 ---------------------------------------------------------
PROMPT Create Trigger PHARMACY_SALE_AI_01
Rem	 ---------------------------------------------------------

DROP TRIGGER pharmacy_sale_ai_01;

CREATE OR REPLACE TRIGGER pharmacy_sale_ai_01
AFTER INSERT   on sales_info REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE

	lv_errmsg			VARCHAR2(2000);
	lv_unit_price		NUMBER;
	lv_availabe_qty	NUMBER;
	lv_updqty			NUMBER;

BEGIN

	BEGIN
		
		SELECT	unit_price,
				availabe_qty 
		INTO	lv_unit_price,
				lv_availabe_qty
		FROM	med_info
		WHERE	MED_ID = :new.med_id;

	EXCEPTION

		WHEN NO_DATA_FOUND THEN
			lv_errmsg := 'From pharmacy_sale_ai_01 - when Query Invalid MEDICAL_ID = '||:new.med_id||'error = '||sqlerrm;
			raise_application_error(-20001,lv_errmsg);
			
		WHEN OTHERS THEN

			lv_errmsg := 'From pharmacy_sale_ai_01 - when Query Other Error MEDICAL_ID = '||:new.med_id||'error = '||sqlerrm;
			raise_application_error(-20002,lv_errmsg);
	END;
	
		lv_updqty	:= lv_availabe_qty-:new.sale_qty;

		IF lv_updqty <0 THEN
			lv_errmsg := 'Available quantity should be greater than sale quantity Sale Qty = '||:new.sale_qty||', Available Qty = '||lv_availabe_qty;
			raise_application_error(-20003,lv_errmsg);
		ELSE
			BEGIN

				UPDATE	med_info
				SET		availabe_qty = lv_updqty
				WHERE	med_id = :new.med_id;

			EXCEPTION

				WHEN OTHERS THEN
					lv_errmsg := 'From pharmacy_sale_ai_01 - when update  MEDICAL_ID = '||:new.med_id||'error = '||sqlerrm;
					raise_application_error(-20004,lv_errmsg);
			END;

		END IF;


EXCEPTION

	WHEN OTHERS THEN

		lv_errmsg := 'From pharmacy_sale_ai_01 - MAIN when insert SALE_QTY error = '||sqlerrm;
		raise_application_error(-20004,lv_errmsg);		
	
END PHARMACY_SALE_AI_01;
/

SELECT * FROM USER_ERRORS WHERE NAME = 'PHARMACY_SALE_AI_01';

SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') END_TIME FROM DUAL;


Rem	 ---------------------------------------------------------
PROMPT Create Trigger PHARMACY_SALE_BI_02
Rem	 ---------------------------------------------------------


DROP TRIGGER pharmacy_sale_bi_02;

CREATE OR REPLACE TRIGGER pharmacy_sale_bi_02
BEFORE INSERT   on sales_info REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE

	lv_errmsg			VARCHAR2(2000);
	lv_unit_price		NUMBER;
	lv_availabe_qty	NUMBER;

BEGIN

	BEGIN
		
		SELECT	unit_price,
				availabe_qty 
		INTO	lv_unit_price,
				lv_availabe_qty
		FROM	med_info
		WHERE	MED_ID = :new.med_id;

		:new.sale_value := (lv_unit_price*:new.sale_qty);

	EXCEPTION

		WHEN NO_DATA_FOUND THEN
			lv_errmsg := 'From pharmacy_sale_bi_02 -when Query Invalid MEDICAL_ID = '||:new.med_id||'error = '||sqlerrm;
			raise_application_error(-20001,lv_errmsg);
			
		WHEN OTHERS THEN

			lv_errmsg := 'From pharmacy_sale_bi_02 - when Query Other Error MEDICAL_ID = '||:new.med_id||'error = '||sqlerrm;
			raise_application_error(-20002,lv_errmsg);
	END;
	

EXCEPTION

	WHEN OTHERS THEN

		lv_errmsg := 'From pharmacy_sale_bi_02 - MAIN when Query unit_price error = '||sqlerrm;
		raise_application_error(-20004,lv_errmsg);		
	
END PHARMACY_SALE_BI_02;
/

SELECT * FROM USER_ERRORS WHERE NAME = 'PHARMACY_SALE_BI_02';



SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') END_TIME FROM DUAL;

SPOOL OFF;

