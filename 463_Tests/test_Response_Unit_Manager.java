/*
 * Response_Unit_Manager.java
 */
 
/**
 * Case Number: 0301
 * Testing: Add_Response_Unit()
 * What is Being Tested: New_Unit == null
 * Previous Tests Needed: none
 * Conditions Needed: New_Unit must be NULL
 * Input: Response_Unit New_Unit
 * Excepted Output: throw Null_Object_Exception()
 */
 
/**
 * Case Number: 0302
 * Testing: Add_Response_Unit()
 * What is Being Tested: If another unit with same ID exists
 * Previous Tests Needed: none
 * Conditions Needed: Response_Unit must already exist in DB
 * Input: Response_Unit New_Unit
 * Excepted Output: throw Duplicate_Item_Exception
 */
 
/**
 * Case Number: 0303
 * Testing: Add_Response_Unit()
 * What is Being Tested: New_Unit is not NULL and not a duplicate
 * Previous Tests Needed: none
 * Conditions Needed: none
 * Input: Response_Unit New_Unit
 * Excepted Output: put Response Unit is DB
 */
 
/**
 * Case Number: 0304
 * Testing: Response_Unit_Named ()
 * What is Being Tested: get Response_Unit from DB
 * Previous Tests Needed: none
 * Conditions Needed: Respone_Unit must exist in DB
 * Input: String Unit_ID
 * Excepted Output: Response_Unit
 */
 
/**
 * Case Number: 0305
 * Testing: Response_Unit_Exists (String Unit_ID)
 * What is Being Tested: Test for when unit exists
 * Previous Tests Needed: none
 * Conditions Needed: DB needs to be filled
 * Input: Existing Unit_ID
 * Excepted Output: True
 */
 
/**
 * Case Number: 0306
 * Testing: Response_Unit_Exists (String Unit_ID)
 * What is Being Tested: Test for when unit does not exists
 * Previous Tests Needed: none
 * Conditions Needed: DB needs to be filled
 * Input: New Unit_ID
 * Excepted Output: False
 */