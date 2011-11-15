package com.ardublock;

import processing.app.Editor;
import com.ardublock.core.Context;

import processing.app.tools.Tool;

import com.ardublock.ui.OpenblocksFrame;
import com.ardublock.ui.listener.OpenblocksFrameListener;

public class ArduBlockTool implements Tool, OpenblocksFrameListener
{
	static Editor editor;
	static OpenblocksFrame openblocksFrame;
	
	public void init(Editor editor) {
		if (ArduBlockTool.editor == null ) {
			ArduBlockTool.editor = editor;
			ArduBlockTool.openblocksFrame = new OpenblocksFrame();
			ArduBlockTool.openblocksFrame.addListener(this);
		}
	}

	public void run() {
		try {
			ArduBlockTool.editor.toFront();
			ArduBlockTool.openblocksFrame.setVisible(true);
			ArduBlockTool.openblocksFrame.toFront();
		} catch (Exception e) {
			
		}
	}

	public String getMenuTitle() {
		return Context.APP_NAME + " Tool";
	}

	public void didSave() {
		
	}
	public void didLoad() {
		
	}
	public void didGenerate(String source) {
		ArduBlockTool.editor.setText(source);
		ArduBlockTool.editor.handleExport(false);
	}
}