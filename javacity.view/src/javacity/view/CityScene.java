package javacity.view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CityScene extends SubScene {

	private static final Xform cityWorld = new Xform();

    private static final PerspectiveCamera camera = new PerspectiveCamera(true);
    private static final Xform cameraXform = new Xform();
    private static final Xform cameraXform2 = new Xform();
    private static final Xform cameraXform3 = new Xform();

    private static final double CAMERA_INITIAL_DISTANCE = -3;
    private static final double CAMERA_INITIAL_X_ANGLE = 0.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 0.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10.0;
    private static final double CONTROL_MULTIPLIER = 0.1;
    private static final double SHIFT_MULTIPLIER = 10.0;
    private static final double MOUSE_SPEED = 0.1;
    private static final double ROTATION_SPEED = 2.0;
    private static final double TRACK_SPEED = 0.3;

    double mousePosX;
    double mousePosY;
    double mouseOldX;
    double mouseOldY;
    double mouseDeltaX;
    double mouseDeltaY;


	public CityScene(Parent arg0, double arg1, double arg2) {
		this(arg0, arg1, arg2, false, SceneAntialiasing.DISABLED);
	}
	public CityScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
		super(root, width, height, depthBuffer, antiAliasing);
		this.build((Group)root);
	}


    private void build(Group root) {
        System.out.println("buildCamera()");
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        //cameraXform3.setRotateZ(180.0);

        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);

        this.handleMouse();
        this.handleKeyboard();
        this.setCamera(camera);
    }


    private void handleMouse() {
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseOldX = me.getSceneX();
                mouseOldY = me.getSceneY();
            }
        });
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseDeltaX = (mousePosX - mouseOldX);
                mouseDeltaY = (mousePosY - mouseOldY);

                double modifier = 1.0;

                if (me.isControlDown()) {
                    modifier = CONTROL_MULTIPLIER;
                }
                if (me.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }
                if (me.isPrimaryButtonDown()) {
                    cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED);
                    cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED);
                }
                else if (me.isSecondaryButtonDown()) {
                    double z = camera.getTranslateZ();
                    double newZ = z + mouseDeltaX*MOUSE_SPEED*modifier;
                    camera.setTranslateZ(newZ);
                }
                else if (me.isMiddleButtonDown()) {
                    cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);
                    cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);
                }
            }
        });
    }

    private void handleKeyboard() {
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Z:
                        cameraXform2.t.setX(0.0);
                        cameraXform2.t.setY(0.0);
                        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
                        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
                        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
                        break;
                    default:
                    	break;
                }
            }
        });
    }


//	/**
//	 * Add all behaviors to this view model. This method will add a {@link MouseRotationBehavior}, {@link MouseSelectionBehavior}, {@link MouseWheelZoomBehavior} and
//	 * {@link KeyboardBehavior} to the specified canvas or the root branch group {@link #root}.
//	 *
//	 * @param cityCanvas
//	 *            The canvas to add the behaviors to.
//	 */
//	private void addBehaviors(final CityCanvas cityCanvas) {
//
//		final BoundingSphere bounds = new BoundingSphere(new Point3d(), Float.MAX_VALUE);
//
//		// add transform group to root (parent) to allow mouse initiated rotations
//		final TransformGroup rootTG = new TransformGroup();
//		rootTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
//		rootTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//
//		rootTG.addChild(this.rootParent);
//		this.root.addChild(rootTG);
//
//		// add selection behavior
//		final MouseSelectionBehavior selectionBehavior = new MouseSelectionBehavior(cityCanvas);
//		selectionBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(selectionBehavior);
//
//		// add keyboard behavior
//		final KeyboardBehavior keyboardBehavior = new KeyboardBehavior(this.universe.getViewingPlatform().getViewPlatformTransform());
//		keyboardBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(keyboardBehavior);
//
//		// add mouse rotation behavior
//		final MouseRotationBehavior rotationBehavior = new MouseRotationBehavior(rootTG);
//		rotationBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(rotationBehavior);
//
//		// add zoom behavior
//		final MouseWheelZoomBehavior zoomBehavior = new MouseWheelZoomBehavior(this.universe.getViewingPlatform().getViewPlatformTransform());
//		zoomBehavior.setEnable(true);
//		zoomBehavior.setSchedulingBounds(bounds);
//		this.root.addChild(zoomBehavior);
//	}
}
