package oscilloscope.Button.ButtonHandler;

import java.awt.Point;

public class Buttons {
	
	public static Button SHOW_GRID = new Button(new Point(920, 600), 100, 30, "show_grid", "Grid", 30);
	public static Button LIGHTEN = new Button(new Point(920, 640), 100, 30, "lighten", "Lighten", 16);
	public static Button DARKEN = new Button(new Point(920, 680), 100, 30, "darken", "Darken", 20);
	public static Button CROSS = new Button(new Point(920, 720), 100, 30, "cross", "Cross", 25);
	public static Button OPENIMAGE = new Button(new Point(1060, 600), 100, 30, "openImage", "Reference", 5);
	public static Button SHOWIMAGE = new Button(new Point(1060, 640), 100, 30, "showImage", "Show/Hide", 5);
	public static Button TRANSLUCENCY_UP = new Button(new Point(1060, 720), 30, 30, "translucencyUp", "+", 11);
	public static Button TRANSLUCENCY_DOWN = new Button(new Point(1096, 720), 30, 30, "translucencyDown", "-", 10);
	public static Button TRANSLUCENCY_MAX = new Button(new Point(1132, 720), 30, 30, "translucencyMax", "M", 10);
	public static Button ORIGIN = new Button(new Point(1060, 800), 100, 30, "goToOrigin", "Origin", 20);
	public static Button SCALEUP = new Button(new Point(920, 800), 30, 30, "scaleUp", "+", 10);
	public static Button SCALEDOWN = new Button(new Point(956, 800), 30, 30, "scaleDown", "-", 10);
	public static Button SCALEFULL = new Button(new Point(992, 800), 30, 30, "scaleFull", "N", 10);
	public static Button CHSWAP = new Button(new Point(1790, 600), 100, 30, "chSwap", "Swap", 30);
	public static Button DRAW = new Button(new Point(1240, 640), 100, 30, "draw", "Draw", 30);
	public static Button FINISH = new Button(new Point(1240, 680), 100, 30, "finish", "Finish", 22);
	public static Button UPDATE = new Button(new Point(1240, 720), 100, 30, "update", "Update", 19);
	public static Button PLOT = new Button(new Point(1240, 760), 100, 30, "plot", "Plot", 30);
	public static Button STEPSUP = new Button(new Point(1240, 840), 30, 30, "stepsUp", "+", 11);
	public static Button STEPSDOWN = new Button(new Point(1276, 840), 30, 30, "stepsDown", "-", 10);
	public static Button STEPSNORMAL = new Button(new Point(1312, 840), 30, 30, "stepsNormal", "N", 10);
	public static Button SAVEJSON = new Button(new Point(1400, 640), 100, 30, "saveJSON", "Save", 30);

	public static Button[] BUTTONS = {
			SHOW_GRID,
			LIGHTEN,
			DARKEN,
			CROSS,
			OPENIMAGE,
			SHOWIMAGE,
			TRANSLUCENCY_UP,
			TRANSLUCENCY_DOWN,
			TRANSLUCENCY_MAX,
			ORIGIN,
			SCALEUP,
			SCALEDOWN,
			SCALEFULL,
			CHSWAP,
			DRAW,
			FINISH,
			UPDATE,
			PLOT,
			STEPSUP,
			STEPSDOWN,
			STEPSNORMAL,
			SAVEJSON
	};

}
