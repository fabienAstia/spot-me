DROP TABLE IF EXISTS t_bros;

CREATE TABLE t_bros(
	name varchar(20),
	cash SMALLINT check(cash>=0)
);

INSERT INTO t_bros (name, cash) VALUES 
('mario', 1000),
('luigi', 100);

SELECT * FROM t_bros;

UPDATE t_bros 
	SET cash = 100 
	WHERE name = 'luigi';
UPDATE t_bros SET cash = cash-5 WHERE name = 'luigi';
UPDATE t_bros SET cash = cash+5 WHERE name = 'luigi';

COMMIT;
ROLLBACK;
-- annule toutes les opérations depuis le dernier commit