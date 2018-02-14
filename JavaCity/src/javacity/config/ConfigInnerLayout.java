package javacity.config;

import javax.xml.bind.annotation.XmlAttribute;

import javacity.view.InnerLayout;
import javacity.view.layout.ChessboardLayout;

public class ConfigInnerLayout {
	@XmlAttribute
	Class<? extends InnerLayout> layoutId;
	@XmlAttribute
	float horizontalMargin;
	@XmlAttribute
	float horizontalGap;
	@XmlAttribute
	float verticalMargin;
	@XmlAttribute
	float verticalGap;

	public ConfigInnerLayout() {
		this.layoutId = ChessboardLayout.class;
		this.horizontalMargin = 0.5f;
		this.horizontalGap = 1;
		this.verticalMargin = 0.2f;
		this.verticalGap = 1;
	}

	public ConfigInnerLayout(Class<? extends InnerLayout> layoutId, float horizontalMargin, float horizontalGap, float verticalMargin, float verticalGap) {
		this.layoutId = layoutId;
		this.horizontalMargin = horizontalMargin;
		this.horizontalGap = horizontalGap;
		this.verticalMargin = verticalMargin;
		this.verticalGap = verticalGap;
	}

	public InnerLayout createInnerLayout() {
		Class<?>[] paramTypes = {float.class, float.class, float.class, float.class};
		InnerLayout layout = null;
		try {
			layout = (InnerLayout) this.layoutId.getConstructor(paramTypes).newInstance(this.horizontalMargin, this.horizontalGap, this.verticalMargin, this.verticalGap);
		} catch (ReflectiveOperationException  e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return layout;
	}

}
