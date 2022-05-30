### To run
- scalaExample
  - `sbt fastOptJS`


- scalaExample_(2,3,4,5)
    - make sure to use new npm version `nvm use v16.1.0` (once is enough)
    - `sbt fastOptJS::webpack`


- scalaExample_6
  - to **build** backend: `sbt ';project flashtalkJVM; compile'`
  - to **build** frontend: `sbt ';project flashtalkJS; fastOptJS::webpack'`
  - to **run** backend: `sbt ';project flashtalkJVM; run'` (make sure port 8080 is available)


In all examples frontend is available by entering index.html (from intelIJ)

### To make it work in intelIJ

For each scalaExample folder:
- File -> Project structure -> modules 
- Click + button (Add) -> Import module -> select scalaExample* folder.