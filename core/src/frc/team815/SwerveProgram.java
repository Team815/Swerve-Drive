package frc.team815;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.ScreenUtils;

public class SwerveProgram extends ApplicationAdapter {
	final int axisLeftX = 0;
	final int axisLeftY = 1;
	final int axisRightX = 2;
	final int axisRightY = 3;

	Controller controller;
	SwerveDrive swerveDrive;

	
	@Override
	public void create () {
		controller = Controllers.getCurrent();
		swerveDrive = new SwerveDrive(.76, .76);
	}

	@Override
	public void render () {
		ScreenUtils.clear(.8f, .8f, .8f, 1);
		var leftY = controller.getAxis(axisLeftY);
		var leftX = controller.getAxis(axisLeftX);
		var rightX = controller.getAxis(axisRightX);
		swerveDrive.setModules(leftX, -leftY, rightX);
		swerveDrive.render();
	}

	@Override
	public void dispose () {
	}
}
