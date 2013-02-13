/**
 *  Catroid: An on-device visual programming system for Android devices
 *  Copyright (C) 2010-2013 The Catrobat Team
 *  (<http://developer.catrobat.org/credits>)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *  
 *  An additional term exception under section 7 of the GNU Affero
 *  General Public License, version 3, is available at
 *  http://developer.catrobat.org/license_additional_term
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *  
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.content.actions;

import org.catrobat.catroid.common.CostumeData;
import org.catrobat.catroid.content.Sprite;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Array;

public class ExtendedActions extends Actions {

	public static BroadcastAction broadcast(Sprite sprite, String broadcastMessage) {
		BroadcastAction action = action(BroadcastAction.class);
		action.setSprite(sprite);
		action.setBroadcastMessage(broadcastMessage);
		return action;
	}

	public static GlideToAction glideTo(Sprite sprite, float x, float y) {
		GlideToAction action = action(GlideToAction.class);
		action.setSprite(sprite);
		action.setPosition(x, y);
		return action;
	}

	public static HideAction hide(Sprite sprite) {
		HideAction action = action(HideAction.class);
		action.setSprite(sprite);
		return action;
	}

	public static SetCostumeAction setCostume(Sprite sprite, CostumeData costume) {
		SetCostumeAction action = action(SetCostumeAction.class);
		action.setSprite(sprite);
		action.setCostumeData(costume);
		return action;
	}

	public static ShowAction show(Sprite sprite) {
		ShowAction action = action(ShowAction.class);
		action.setSprite(sprite);
		return action;
	}

	public static SequenceAction copySequenceAction(SequenceAction source) {
		SequenceAction destination = ExtendedActions.sequence();
		Array<Action> sourceActions = source.getActions();
		Array<Action> destActions = new Array<Action>(sourceActions);
		for (Action action : destActions) {
			action.restart();
			destination.addAction(action);
		}
		destination.restart();
		return destination;
	}

}
