SRC_DIR = src
CLASS_DIR = classes
PACKAGE_DIR = game
MAIN_CLASS = MainL1

JAVAC = javac
JAVA = java

JAVAC_FLAGS = -d $(CLASS_DIR) -sourcepath $(SRC_DIR)

all: compile run

compile:
	$(JAVAC) $(JAVAC_FLAGS) $(SRC_DIR)/$(PACKAGE_DIR)/*.java

run:
	$(JAVA) -cp $(CLASS_DIR) $(PACKAGE_DIR).$(MAIN_CLASS)

clean:
	rm -rf $(CLASS_DIR)
