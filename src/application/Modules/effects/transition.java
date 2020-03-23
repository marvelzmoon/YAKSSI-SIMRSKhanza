package application.Modules.effects;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class transition {
	public void fadeIn(int milis, Node node) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
	}
}
