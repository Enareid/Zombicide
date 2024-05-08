SRC_DIR = src
TEST_DIR = test
CLASS_DIR = classes
PACKAGE_DIR = game
MAINBIS = MainBis
MAIN = Main
CONSOLE = junit-console.jar

JAVAC = javac
JAVA = java

JAVAC_FLAGS = -d $(CLASS_DIR) -sourcepath $(SRC_DIR)

all: cls

cls:
	$(JAVAC) $(JAVAC_FLAGS) $(SRC_DIR)/$(PACKAGE_DIR)/*.java

run: jar
	$(JAVA) -jar Livrable1.jar

test: cls
	$(JAVAC) -cp $(CONSOLE):$(CLASS_DIR) $(TEST_DIR)/$(PACKAGE_DIR)/*.java
	$(JAVA) -jar $(CONSOLE) -cp $(TEST_DIR):$(CLASS_DIR) -scan-classpath

zombicide.jar: cls
	jar cvfe zombicide.jar $(PACKAGE_DIR).$(MAIN) -C $(CLASS_DIR) $(PACKAGE_DIR)

zombicideBis.jar: cls
	jar cvfe zombicideBis.jar $(PACKAGE_DIR).$(MAINBIS) -C $(CLASS_DIR) $(PACKAGE_DIR)

doc: cls
	javadoc -sourcepath $(SRC_DIR) -subpackages $(PACKAGE_DIR) -d docs

clean:
	rm -rf $(CLASS_DIR) docs
	rm -f $(TEST_DIR)/$(PACKAGE_DIR)/*.class
