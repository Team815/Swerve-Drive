package frc.team815;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.ScreenUtils;

public class SwerveProgram extends ApplicationAdapter {
	final int axisLeftX = 0;
	final int axisLeftY = 1;
	final int axisRightX = 2;

	Controller controller;

	
	@Override
	public void create () {
		controller = Controllers.getCurrent();
	}

	@Override
	public void render () {
		ScreenUtils.clear(.8f, .8f, .8f, 1);
		var leftX = controller.getAxis(axisLeftX);
		var leftY = controller.getAxis(axisLeftY);
		var rightX = controller.getAxis(axisRightX);
	}
}
