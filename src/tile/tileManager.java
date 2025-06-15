package tile;


import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;

public class tileManager {
	
	GamePanel gp;
    public Tile[] tile;
	public int mapTileNum[][]; 
	public tileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/worldmap60.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[11].collision = true;
			
			tile[12] = new Tile();		
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[12].collision = true;
			
			tile[13] = new Tile();		
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flowergrass.png"));
			
			tile[14] = new Tile();		
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/berrytree.png"));
			tile[14].collision = true;
			
			tile[15] = new Tile();		
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[15].collision = true;
			
			tile[16] = new Tile();		
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[17] = new Tile();		
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/darksand.png"));
			
			tile[18] = new Tile();		
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door.png"));
			tile[18].collision = true;
			
			tile[19] = new Tile();		
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rooftop1.png"));
			tile[19].collision = true;
			
			tile[20] = new Tile();		
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rooftop.png"));
			tile[20].collision = true;
		
			tile[21] = new Tile();		
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rooftop2.png"));
			tile[21].collision = true;
			
			tile[22] = new Tile();		
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall1.png"));
			tile[22].collision = true;
			
			tile[23] = new Tile();		
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall2.png"));
			tile[23].collision = true;
			
			tile[24] = new Tile();		
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road1.png"));
			tile[24].collision = true;
			
			tile[25] = new Tile();		
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road2.png"));
			tile[25].collision = true;
			
			tile[26] = new Tile();		
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterdown.png"));
			
			tile[27] = new Tile();		
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterup.png"));
			
			tile[28] = new Tile();		
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterleft.png"));
			
			tile[29] = new Tile();		
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterright.png"));
			

			tile[30] = new Tile();		
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterdown1.png"));
			
			tile[31] = new Tile();		
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterdown2.png"));
			
			tile[32] = new Tile();		
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterup1.png"));
			
			tile[33] = new Tile();		
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterup2.png"));
			
			tile[34] = new Tile();		
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road1.png"));
			
			tile[35] = new Tile();		
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road2.png"));

			tile[36] = new Tile();		
			tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road3.png"));
			
			tile[37] = new Tile();		
			tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road4.png"));
			
			tile[38] = new Tile();		
			tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road.png"));
			
			tile[39] = new Tile();		
			tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road5.png"));
			
			tile[40] = new Tile();		
			tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road7.png"));
			
			
		}		
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		}
	
	public void loadMap(String fllePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(fllePath);
			BufferedReader br = new  BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow ) {
            	
            	String line = br.readLine();
            	
            	while(col< gp.maxWorldCol) {
            		String numbers[] = line.split(" ");
            		
            		int num = Integer.parseInt(numbers[col]);
            		
            	mapTileNum[col][row] = num;
            	col++;
            	
            	}
            	if(col == gp.maxWorldCol) {
            		col=0;
            		row++;
            	}
            }
            
            br.close();
       	
		}
		catch(Exception e) {
			
		}
	    
		
	}
	
	public void drew(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow ) {
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX ;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                    	g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize, null);
                    }
                    
			g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize, null);
			worldCol++;

			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
				
			}
		
		}
		
	}
}
