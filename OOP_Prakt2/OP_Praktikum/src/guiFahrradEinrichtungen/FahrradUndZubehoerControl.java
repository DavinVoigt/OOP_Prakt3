package guiFahrradEinrichtungen;
import observer.Observer;
import business.FahrradGeschaeftModel;
import javafx.stage.Stage;

public class FahrradUndZubehoerControl implements Observer{

	private FahrradUndZubehoerView fahrraederUndZubehoerView;
	private FahrradGeschaeftModel fahrraederModel;

	public FahrradUndZubehoerControl(Stage primaryStage) {
		this.fahrraederModel = FahrradGeschaeftModel.getInstance();
		this.fahrraederUndZubehoerView = new FahrradUndZubehoerView(this, primaryStage, fahrraederModel);
		this.fahrraederModel.addObserver(this);
	}

	@Override
	public void update() {
		fahrraederUndZubehoerView.zeigeFahrraederAn();
		// TODO Auto-generated method stub
	}
}
