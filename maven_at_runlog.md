```ShellSession

Nameless One@VaultStation MINGW64 /k/Java/Projects/maven_at (lesson02)
$ mvn -v
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\lib\apache-maven-3.6.3
Java version: 1.8.0_221, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_221\jre
Default locale: ru_RU, platform encoding: Cp1251
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

Nameless One@VaultStation MINGW64 /k/Java/Projects/maven_at (lesson02)
$ mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< org.example:maven_at >------------------------
[INFO] Building maven_at 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ maven_at ---
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_at ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ maven_at ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 9 source files to K:\Java\Projects\maven_at\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ maven_at ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory K:\Java\Projects\maven_at\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ maven_at ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven_at ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:3.1.0:jar (default-jar) @ maven_at ---
[INFO] Building jar: K:\Java\Projects\maven_at\target\maven_at-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ maven_at ---
[INFO] Installing K:\Java\Projects\maven_at\target\maven_at-1.0-SNAPSHOT.jar to C:\Users\Nameless One\.m2\repository\org\example\maven_at\1.0-SNAPSHOT\maven_at-1.0-SNAPSHOT.jar
[INFO] Installing K:\Java\Projects\maven_at\pom.xml to C:\Users\Nameless One\.m2\repository\org\example\maven_at\1.0-SNAPSHOT\maven_at-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.501 s
[INFO] Finished at: 2020-04-07T20:32:22+03:00
[INFO] ------------------------------------------------------------------------

Nameless One@VaultStation MINGW64 /k/Java/Projects/maven_at (lesson02)
$ cd target/

Nameless One@VaultStation MINGW64 /k/Java/Projects/maven_at/target (lesson02)
$ java -jar maven_at-1.0-SNAPSHOT.jar
Passing an obstacle Racetrack 1: distance = 80,00
Human runs for 80,00 meters
Barsik runs for 80,00 meters
Electronik runs for 80,00 meters

Passing an obstacle Wall 1: height = 0,60
Human jumps for 0,60 meters
Barsik jumps for 0,60 meters
Electronik jumps for 0,60 meters

Passing an obstacle Racetrack 2: distance = 160,00
Human runs for 160,00 meters
Barsik runs for 100,00 meters. Can't do more...
Electronik runs for 160,00 meters

Passing an obstacle Wall 2: height = 1,20
Human jumps for 1,20 meters
Electronik jumps for 1,20 meters

Passing an obstacle Racetrack 3: distance = 240,00
Human runs for 240,00 meters
Electronik runs for 240,00 meters

Passing an obstacle Wall 3: height = 1,80
Human jumps for 1,50 meters. Can't do more...
Electronik jumps for 1,80 meters

Passing an obstacle Racetrack 4: distance = 320,00
Electronik runs for 320,00 meters

Passing an obstacle Wall 4: height = 2,40
Electronik jumps for 2,40 meters


Nameless One@VaultStation MINGW64 /k/Java/Projects/maven_at/target (lesson02)
$


```