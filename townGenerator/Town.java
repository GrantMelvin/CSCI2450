package townGenerator;

public class Town {

	private String location ;
	private String famous1 ;
	private String famous2 ;
	private String income ;
	private String local1 ;
	private String local2 ;
	
	
	public Town() {
		this.location = locationGenerator() ;
		this.famous1 = famous1Generator() ;
		this.famous2 = famous2Generator() ;
		this.income = incomeGenerator() ;
		this.local1 = local1Generator() ;
		this.local2 = local2Generator() ;
	}
	
	
	public String locationGenerator(){
		
		int num = (int)(Math.random() * (10 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "on an island" ;
		
		case 2:
			return "in a forest" ;
		
		case 3:
			return "underground" ;
		
		case 4:
			return "in a volcano" ;
		
		case 5:
			return "in a swamp" ;
		
		case 6:
			return "on the coast" ;
		
		case 7:
			return "in the clouds" ;
		
		case 8:
			return "on a cliff edge" ;
		
		case 9:
			return "in the jungle" ;
		
		case 10:
			return "in a dungeon" ;
		default:
			return null ;
		}
	}
	
	public String famous1Generator(){
		
		int num = (int)(Math.random() * (10 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "haunted" ;
		
		case 2:
			return "ancient" ;
		
		case 3:
			return "maze-like" ;
		
		case 4:
			return "iconic" ;
		
		case 5:
			return "immense" ;
		
		case 6:
			return "disturbing" ;
		
		case 7:
			return "ever-growing" ;
		
		case 8:
			return "nonsensical" ;
		
		case 9:
			return "chaotic" ;
		
		case 10:
			return "bizarre" ;
		default:
			return null ;
		}
	}

	public String famous2Generator(){
	
		int num = (int)(Math.random() * (10 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "brewery" ;
		
		case 2:
			return "pie shop" ;
		
		case 3:
			return "temple" ;
		
		case 4:
			return "sewers" ;
		
		case 5:
			return "art gallery" ;
		
		case 6:
			return "hat shop" ;
		
		case 7:
			return "coffee shop" ;
		
		case 8:
			return "library" ;
		
		case 9:
			return "pet shop" ;
		
		case 10:
			return "wizard tower" ;
			
		default:
			return null ;
			}
		}
	
	public String incomeGenerator() {
		
		int num = (int)(Math.random() * (10 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "tourism" ;
		
		case 2:
			return "potions" ;
		
		case 3:
			return "farming" ;
		
		case 4:
			return "transportation" ;
		
		case 5:
			return "education" ;
		
		case 6:
			return "mining" ;
		
		case 7:
			return "crime" ;
		
		case 8:
			return "hunting" ;
		
		case 9:
			return "trading" ;
		
		case 10:
			return "weapons" ;
		default:
			return null ;
			}
		}

	public String local1Generator() {
		int num = (int)(Math.random() * (16 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "corrupted" ;
		
		case 2:
			return "immortal" ;
		
		case 3:
			return "reclusive" ;
		
		case 4:
			return "generous" ;
		
		case 5:
			return "meddlesome" ;
		
		case 6:
			return "charismatic" ;
		
		case 7:
			return "exiled" ;
		
		case 8:
			return "greedy" ;
		
		case 9:
			return "cursed" ;
		
		case 10:
			return "lonely" ;
		
		case 11:
			return "kraken-worshipping" ;
			
		case 12:
			return "devil-worshipping" ;
		
		case 13:
			return "demon-worshipping" ;
			
		case 14:
			return "aboleth-worshipping" ;
			
		case 15:
			return "watchful" ;
		
		case 16:
			return "giant" ;
			
		default:
			return null ;
			}
		}
	
	public String local2Generator() {
		int num = (int)(Math.random() * (13 - 1 + 1) + 1)  ;
		
		switch(num) {
		case 1:
			return "crime lord" ;
		
		case 2:
			return "goblin" ;
		
		case 3:
			return "diety" ;
		
		case 4:
			return "wizard" ;
		
		case 5:
			return "doppelgänger" ;
		
		case 6:
			return "vampire" ;
		
		case 7:
			return "ex-adventurer" ;
		
		case 8:
			return "alchemist" ;
		
		case 9:
			return "ghost" ;
		
		case 10:
			return "automaton" ;
		
		case 11:
			return "troll" ;
			
		case 12:
			return "orc" ;
		
		case 13:
			return "owl-bear" ;
		default:
			return null ;
			}
		}
	
	public String toString() {
		return "A town situated " + this.location + ". It is famous for its " + this.famous1 + " " + this.famous2 +
				".\nThe town's main income comes from " + this.income + ".\nRumors have it, one of the locals is a " + this.local1 + " " + this.local2 + ".\n" ;
	}
	
}
