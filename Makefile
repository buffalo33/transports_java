CC = javac
CFLAGS =
EXEC = java
TFLAGS = -ea
A_TESTER = tec.TestJauge tec.TestPosition tec.TestAutobus tec.TestPassagerSportifNerveux tec.TestCollect tec.TestGreffon


SRC = src
TST = tst
BUILD = build

all: source run file memo

source:
	$(CC) -d $(BUILD) -cp $(SRC)/*.java
	$(CC) -d $(BUILD) -cp $(BUILD) $(TST)/*.java

test:
	$(EXEC) $(TFLAGS) -cp $(BUILD) tec.LancerTests $(A_TESTER)
#$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestAutobus
#	$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestJauge
#	$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestPosition
#	#$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestPassagerStandard
#	#$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestPassagerStresse
#	#$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestPassagerIndecis
#	$(EXEC) $(TFLAGS) -cp $(BUILD) tec.TestPassagerSportifNerveux

run:
	$(EXEC) $(TFLAGS) -cp $(BUILD) tec.ExecutionExemple
	$(EXEC) $(TFLAGS) -cp $(BUILD) Simple

file:
	$(EXEC) $(TFLAGS) -cp $(BUILD) SimpleFile

memo:
	$(EXEC) $(TFLAGS) -cp $(BUILD) SimpleMemo

clean:
	rm -rf $(SRC)/*~ $(TST)/*~ $(BUILD)/* ./*~
