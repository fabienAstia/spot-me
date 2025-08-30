SELECT * FROM t_bros;

UPDATE t_bros
	SET cash = cash - 75
	WHERE name = 'mario';