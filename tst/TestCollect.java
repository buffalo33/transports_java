package tec;

class TestCollect {

    public static void main (String[] args) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;

	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	int nbTest = 0;
	System.out.print('!');nbTest++;
	new TestCollect().testAddMemory();

	System.out.print('.'); nbTest++;
	new TestCollect().testUneEntree();

	System.out.print('.'); nbTest++;
	new TestCollect().testUneSortie();

	System.out.print('.'); nbTest++;
	new TestCollect().testChangerArret();
    }

public void testUneEntree()
    {
	Passager p = new MonteeSportif("xxx",3,ArretNerveux.NERVEUX);
	Collect memo = new CollectMemo();
	memo.uneEntree(p);
	assert memo.getNbEntree() == 0 : "nbEntree faux testUneEntree";
    }

    public void testUneSortie()
    {
	Passager p = new MonteeSportif("xxx",3,ArretNerveux.NERVEUX);
	Collect memo = new CollectMemo();;
	memo.uneSortie(p);
	assert memo.getNbSortie() == 0 : "getNbSortie() faux testUneSortie";
    }

    public void testChangerArret()
    {
	Collect memo = new CollectMemo();
	memo.changerArret();
	assert memo.getNumeroArret() == 1 : "getNumeroArret() faux testChangerArret";
    }
    
    public void testAddMemory() {

	CollectMemo memo = new CollectMemo();
	memo.setNbEntree(0);
	memo.setNbSortie(0);
	memo.setNumeroArret(0);
	memo.addMemory();
	assert memo.getNumeroArretMem(0) == 0 : "getNumeroArret 1";
	assert memo.getNbEntreeMem(0) == 0 : "getNbEntree 1";
	assert memo.getNbSortieMem(0) == 0 : "getNbSortie 1";

	memo.setNbEntree(1);
	memo.setNbSortie(0);
	memo.setNumeroArret(3);
	memo.addMemory();

	memo.setNbEntree(2);
	memo.setNbSortie(1);
	memo.setNumeroArret(5);
	memo.addMemory();
	assert memo.getNbEntreeMem(0) == 0 : "getNbEntree 2";
	assert memo.getNbSortieMem(0) == 0 : "getNbSortie 2";
	assert memo.getNumeroArretMem(0) == 0 : "getNumeroArret 2";
	
	assert memo.getNbEntreeMem(1) == 1 : "getNbEntree 3";
	assert memo.getNbSortieMem(1) == 0 : "getNbSortie 3";
	assert memo.getNumeroArretMem(1) == 3 : "getNumeroArret 3";

	assert memo.getNbEntreeMem(2) == 2 : "getNbEntree 4";
	assert memo.getNbSortieMem(2) == 1 : "getNbSortie 4";
	assert memo.getNumeroArretMem(2) == 5 : "getNumeroArret 4";
	
	System.out.println("CollectMemo final Arraylist:\n" + memo.toString());
        }

    
}
	
