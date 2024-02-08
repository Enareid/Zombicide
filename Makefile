SRC_DIR = src
TEST_DIR = test
CLASS_DIR = classes
PACKAGE_DIR = game
MAIN_CLASS = MainL1
CONSOLE = junit-console.jar

JAVAC = javac
JAVA = java

JAVAC_FLAGS = -d $(CLASS_DIR) -sourcepath $(SRC_DIR)

all: run

compile:
	$(JAVAC) $(JAVAC_FLAGS) $(SRC_DIR)/$(PACKAGE_DIR)/*.java

run: jar
	$(JAVA) -jar Livrable1.jar

test: compile
	$(JAVAC) -cp $(CONSOLE):$(CLASS_DIR) $(TEST_DIR)/$(PACKAGE_DIR)/*.java
	$(JAVA) -jar $(CONSOLE) -cp $(TEST_DIR):$(CLASS_DIR) -scan-classpath

jar: compile
	jar cvfe Livrable1.jar $(PACKAGE_DIR).$(MAIN_CLASS) -C $(CLASS_DIR) $(PACKAGE_DIR)

doc: compile
	javadoc -sourcepath $(SRC_DIR) -subpackages $(PACKAGE_DIR) -d docs

clean:
	rm -rf $(CLASS_DIR) doc
