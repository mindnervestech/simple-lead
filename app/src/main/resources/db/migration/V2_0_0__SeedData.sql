INSERT INTO customer (id, created_date, deleted, email, first_name, last_name, modified_date, remarks, sales_guid) VALUES
	(1, '2020-05-05 15:01:29', b'0', 'jagbir.paul@gmail.com', 'Jagbir', 'Singh', '2020-05-05 15:01:53', NULL, 'guid-001'),
	(2, '2020-05-05 15:01:29', b'0', 'amit.goyal@gmail.com', 'Amit', 'Goyal', '2020-05-05 15:01:53', NULL, 'guid-002');
INSERT INTO customer_extra_attributes (id, cf_code, cf_value_string, customer_id) VALUES
	(1, 'secondary_email', 'jagbir_paul@yahoo.com', 1);
INSERT INTO customer_tags (id, tags, customer_id) VALUES
	(1, 'Vip', 1),
	(2, 'Management', 1),
	(3, 'Vip', 2),
	(4, 'CXO', 2);
INSERT INTO lead (id, created_date, lead_source, lead_type, remarks, sales_guid, status, title) VALUES
	(1, '2020-03-05 16:31:05', 'Web', 'Hot', NULL, 'guid-001', 'Converted', 'Rockys Father'),
	(2, '2020-03-23 16:31:05', 'Email', 'Dormant', NULL, 'guid-002', 'Converted', 'CEO of Mindnednerves');
INSERT INTO prospect (id, amount, created_date, deleted, modified_date, name, conversion_probaility, remarks, sales_guid, sales_stage) VALUES
	(1, 1000, '2020-04-30 16:04:51', b'0', '2020-05-05 16:04:57', 'Jagbir ', 50, 'need to call him again', 'guid-001', 'Followup'),
	(2, 5000, '2020-04-27 16:29:11', b'0', '2020-05-05 16:29:12', 'Ameet', 70, 'need to send him discounted quote', 'guid-002', 'Quotation');
