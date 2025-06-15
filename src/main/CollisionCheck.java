package main;

import charactersPkg.Entity;
public class CollisionCheck {
	
	GamePanel gp;
	
	public CollisionCheck(GamePanel gp) {
	      this.gp = gp;	
	}
	
	public void checkTile(Entity charactersPkg) {
		
		int entityLeftWorldX = charactersPkg.worldX + charactersPkg.solidArea.x;
		int entityRightWorldX = charactersPkg.worldX + charactersPkg.solidArea.x + charactersPkg.solidArea.width;
		int entityTopWorldY = charactersPkg.worldY + charactersPkg.solidArea.y;
		int entityBottomWorldY = charactersPkg.worldY + charactersPkg.solidArea.y + charactersPkg.solidArea.height;
		
		int  entityLeftCol =  entityLeftWorldX/gp.tileSize;
		int  entityRightCol = entityRightWorldX/gp.tileSize;
		int  entityTopRow = entityTopWorldY/gp.tileSize;
		int  entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(charactersPkg.direction) {
		
		case "up":
			entityTopRow = (entityTopWorldY - charactersPkg.Speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true ) {
				charactersPkg.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = ( entityBottomWorldY + charactersPkg.Speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true ) {
				charactersPkg.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - charactersPkg.Speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true ) {
				charactersPkg.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + charactersPkg.Speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true|| gp.tileM.tile[tileNum2].collision == true ) {
				charactersPkg.collisionOn = true;
			}
			break;
		
		}
		
     }
}
