SELECT * FROM t_spots ts;
SELECT * FROM t_categories ;

SELECT 
	DISTINCT tc.city_name, 
	count(*) AS nombre_adresses,
	avg(ts.longitude) AS longitude_moyenne,
	avg(ts.latitude) AS latitude_moyenne
FROM
	t_streets ts
LEFT JOIN
	t_cities tc ON ts.city_id = tc.id
GROUP BY 
	tc.city_name
HAVING 
	count(*) >10000
ORDER BY 
	nombre_adresses DESC;
