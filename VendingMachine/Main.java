public class Main {
	public static void main(String[] args) {
		ProgramView view = new ProgramView();
        ProgramModel model = new ProgramModel();

		ProgramController controller = new ProgramController(view, model);
	
	}
}