 

public class MyAkinator {

	private BinaryTree<String> wurzel, baum;
	private Dialog d;

	public MyAkinator() {
		d = new Dialog();
		wurzel = new BinaryTree("Ist es ein Mann?");

		wurzel.setLeftTree(new BinaryTree("Bernard"));
		wurzel.setRightTree((new BinaryTree("Isabelle")));
		baum = wurzel;
		this.fragen();
	}

	private void fragen() {
		// Rechts oder links?
		if (Dialog.entscheidung("Frage", (String) (baum.getContent()))) {
			baum = baum.getLeftTree();
		} else {
			baum = baum.getRightTree();
		}

		// Blatt?
		if (baum.getLeftTree().isEmpty() && baum.getRightTree().isEmpty()) {
			if (d.entscheidungMitBild("Antwort", "Ist es " + baum.getContent()
					+ "?", "/bilder/" + baum.getContent() + ".jpg")) {
				Dialog.info("Gewonnen", "Ich freue mich!");
			} else {
				this.neuePerson();
			}

		} else {
			this.fragen();
		}

	}

	private void neuePerson() {
		baum.setRightTree(new BinaryTree(baum.getContent()));
		baum.setLeftTree(new BinaryTree(Dialog.eingabe("Schade!",
				"Wie heisst deine Person?")));
		baum.setContent(Dialog.eingabe("Neue Person eingeben!",
				"Stelle eine Frage, die " + baum.getLeftTree().getContent()
						+ " von " + baum.getRightTree().getContent()
						+ " positiv unterscheidet!"));
		baum = wurzel;
		
		this.fragen();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyAkinator();
	}

}
