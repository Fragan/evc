package loader;

import java.io.FileNotFoundException;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import org.jdesktop.j3d.loaders.vrml97.VrmlLoader;

import com.sun.j3d.loaders.Scene;

public class GenericVrmlLoader {
	
	
	private String fileName;

	public GenericVrmlLoader(String fileName) {
		this.fileName = fileName;
	}

//	public void init() {
//		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
//		Canvas3D c = new Canvas3D(config);
//		getContentPane().add(c);
//		BranchGroup scene = createSceneGraph();
//		u = new SimpleUniverse(c);
//		u.getViewingPlatform().setNominalViewingTransform();
//		enableInteraction(scene, c);
//		// création d'un navigateur
//		TransformGroup vpTrans = u.getViewingPlatform().getViewPlatformTransform();
//		KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(vpTrans);
//		keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(), 1000.0));
//		scene.addChild(keyNavBeh);
//
//		
//		scene.compile();
//		u.addBranchGraph(scene);
//	}

	@SuppressWarnings("unchecked")
	public BranchGroup createSceneGraph() {
		BranchGroup objRoot = new BranchGroup();

		Color3f directionalColor = new Color3f(1.0f, 1.0f, 1.0f);
		Color3f ambientColor = new Color3f(0.9f, 0.9f, 0.9f);
		Color3f backgroundColor = new Color3f(0.05f, 0.05f, 0.2f);
		DirectionalLight dl = new DirectionalLight(true, directionalColor,
		      new Vector3f(-1.0f, 0.0f, 0.0f));
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
		      100.0);
		dl.setInfluencingBounds(bounds);
		objRoot.addChild(dl);
		AmbientLight ambientLight = new AmbientLight(true, ambientColor);
		ambientLight.setInfluencingBounds(bounds);
		objRoot.addChild(ambientLight);
		Background bg = new Background(backgroundColor);
		bg.setApplicationBounds(bounds);
		objRoot.addChild(bg);

		TransformGroup objTrans = new TransformGroup();
		objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objTrans.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
		objRoot.addChild(objTrans);
		VrmlLoader loader = new VrmlLoader();
		try {
			Scene scene = loader.load(fileName);
			objTrans.addChild(scene.getSceneGroup());
			/*
			// code qui semble inutile : sans lui on a quand même de l'interaction...
			Group group = scene.getSceneGroup();
			Enumeration<Node> nodes =(Enumeration<Node>)group.getAllChildren();
			while(nodes.hasMoreElements()) {
				System.out.println("et un élément de plus !");
				Node node = nodes.nextElement();
				// cas d'une primitive
				try {
					Primitive prim =(Primitive)node;
					System.out.println("c'est une primitive");
					prim.getShape(0).getGeometry().setCapability(
					      Geometry.ALLOW_INTERSECT);
				} catch(ClassCastException e1) {
					try {
						// cas d'un IndexedFaceSet
						Shape3D shape =(Shape3D)(((Group)node).getChild(0));
						System.out.println("c'est une forme 3D");
						shape.getGeometry().setCapability(Geometry.ALLOW_INTERSECT);
					} catch(ClassCastException e2) {
						// ...
					}
				}
			}
			*/
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return objRoot;
	}

//	public void enableInteraction(BranchGroup objRoot, Canvas3D c) {
//		BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), 100);
//		PickRotateBehavior prb = new PickRotateBehavior(objRoot, c, bounds);
//		prb.setMode(PickTool.GEOMETRY);
//		prb.setTolerance(0.0f);
//		objRoot.addChild(prb);
//		PickTranslateBehavior ptb = new PickTranslateBehavior(objRoot, c, bounds);
//		ptb.setMode(PickTool.GEOMETRY);
//		ptb.setTolerance(0.0f);
//		objRoot.addChild(ptb);
//		PickZoomBehavior pzb = new PickZoomBehavior(objRoot, c, bounds);
//		pzb.setMode(PickTool.GEOMETRY);
//		pzb.setTolerance(0.0f);
//		objRoot.addChild(pzb);
//	}	
	
	
}