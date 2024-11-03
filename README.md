Como funciona?

1) Descargar o clonar el repositorio
2) Abrir con el IDE IntelliJ Idea y ejecutarlo localmente para probarlo con postman u open-api swagger, o podes probarlo en la nube a traves de las siguientes urls:
   POST para dar de alta humanos/mutantes -> https://mutant-app.onrender.com/humanos/ismutant
   GET para obtener estadisticas de los humanos/mutantes que estan en la base de datos -> https://mutant-app.onrender.com/humanos/stats
   GET para obtener todos los humanos/mutantes guardados en la base de datos -> https://mutant-app.onrender.com/humanos
3) En el servicio /ismutant vamos a poder ingresar el adn del humano con un arreglo de cadenas que contienen las filas de una matriz NXN. Las matrices deben ser cuadradas. Al momento de ingresar una persona obtendremos el valor de isMutant? true o false dependiendo si es o no mutante.
4) Un ejemplo de mutante seria: { "dna": ["ATCCC","TTTAC","ACATG","CATTT","GGGGA"] } Un ejemplo de humano seria: { "dna": ["ATCCC","TTTAC","ACATG","CATTT","GAGGA"] }
5) En el servicio /stats veremos las estadisticas de humanos y mutantes ingresados. Por ejemplo: { "count_humans": 1, "count_mutants": 1, "ratio": 1.0 }.
6) Por defecto la aplicacion va a tener algunos objetos de humanos/mutantes guardados en la base de datos.
