/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewFrame.java
 *
 * Created on Aug 13, 2011, 10:32:02 AM
 */
//package xmldbr;
import javax.swing.*;

import edu.lsivc.db.DBR;
import edu.lsivc.directory.Directory;
import edu.lsivc.directory.Index_Elements;
import edu.lsivc.video.PlayVideo;
import edu.lsivc.xml.XMLFile;

import java.awt.Font;
//import java.awt.Image.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
//import java.util.Date;
/**
 *
 * @author oscargcervantes
 */
public class ViewFrame extends javax.swing.JFrame 
{
    /**
	 * @uml.property  name="pictureLabel"
	 * @uml.associationEnd  readOnly="true"
	 */
    private JLabel PictureLabel;
    /**
	 * @uml.property  name="dbdir"
	 */
    private String  dbdir;
    /**
	 * @uml.property  name="confdir"
	 */
    private String confdir = null;
    /**
	 * @uml.property  name="settingsdir"
	 */
    private String settingsdir;
    /**
	 * @uml.property  name="xmlfiledir"
	 */
    private String xmlfiledir;
    /**
	 * @uml.property  name="dB"
	 */
    private String DB = "DBGR";
    /**
	 * @uml.property  name="iD"
	 */
    private String ID = "1";
    /**
	 * @uml.property  name="gaitAttr" multiplicity="(0 -1)" dimension="2"
	 */
    private String[][] GaitAttr;
    /**
	 * @uml.property  name="faceAttr" multiplicity="(0 -1)" dimension="2"
	 */
    private String[][] FaceAttr;
    /**
	 * @uml.property  name="gaitElements" multiplicity="(0 -1)" dimension="1"
	 */
    private String[] GaitElements;
    /**
	 * @uml.property  name="faceElements" multiplicity="(0 -1)" dimension="1"
	 */
    private String[] FaceElements;
    /**
	 * @uml.property  name="gaitXMLDirs" multiplicity="(0 -1)" dimension="1"
	 */
    private String[] GaitXMLDirs;
    /**
	 * @uml.property  name="faceXMLDirs" multiplicity="(0 -1)" dimension="1"
	 */
    private String[] FaceXMLDirs;
    /**
	 * @uml.property  name="videoDir"
	 */
    private String VideoDir;
    /**
	 * @uml.property  name="gaitCount"
	 */
    private int GaitCount = 0;
    private int FaceCount = 0;
    /**
	 * @uml.property  name="urlindex"
	 */
    private int urlindex;
    /**
	 * @uml.property  name="personaIndex"
	 */
    private String PersonaIndex;
    /** Creates new form ViewFrame */
    public ViewFrame()
    {
    	initComponents();
        //LoadDirs();
        //LoadIndex();
        DBR db = new DBR();
        this.dbdir = db.GetDBDir();
        this.settingsdir = db.GetSettingsDir(this.dbdir);
        this.PersonaIndex = db.LoadIndex(this.settingsdir);
        
        if(!PersonaIndex.contentEquals("0"))
        {
          for(int i=1;i<=Integer.valueOf(PersonaIndex);i++)
          {	  
        	SelectID.addItem(String.valueOf(i)); //Leer el archivo index de la base de datos para ver cuantas personas existen. Cargar ese numero en el ComboBox	
          }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Forward = new javax.swing.JButton();
        SelectID = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayID = new javax.swing.JTextArea();
        SelectDB = new javax.swing.JComboBox();
        IDLabel = new javax.swing.JLabel();
        DBLabel = new javax.swing.JLabel();
        LabelPicture = new javax.swing.JLabel();
        VideoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DBR LSIVC");
        setAlwaysOnTop(true);
        setName("ViewFrame"); // NOI18N
        setResizable(false);
        this.setAlwaysOnTop(false);

        Back.setText("Back");
        Back.setEnabled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Forward.setText("Forward");
        Forward.setEnabled(false);
        Forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForwardActionPerformed(evt);
            }
        });

        SelectID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));	
        SelectID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectIDActionPerformed(evt);
            }
        });

        DisplayID.setColumns(20);
        DisplayID.setRows(5);
        DisplayID.setText("Display Existing Records in Database");
        jScrollPane1.setViewportView(DisplayID);

        SelectDB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        SelectDB.addItem("DBFR");
        SelectDB.addItem("DBGR");
        SelectDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDBActionPerformed(evt);
            }
        });

        IDLabel.setText("ID");

        DBLabel.setText("DB");
        
        URL logoURL = this.getClass().getClassLoader().getResource("resources/gait.png");
        System.out.println(this.getClass().getClassLoader().getResource(""));
        ImageIcon logo = new ImageIcon(logoURL);
        //InitLabel.setIcon(logo);
        
        LabelPicture.setBackground(new java.awt.Color(13, 9, 5));
        LabelPicture.setIcon(logo); // NOI18N

        VideoButton.setText("Video");
        VideoButton.setEnabled(false);
        VideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Forward, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VideoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(IDLabel)
                            .addGap(2, 2, 2)
                            .addComponent(SelectID, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DBLabel)
                            .addGap(3, 3, 3)
                            .addComponent(SelectDB, 0, 148, Short.MAX_VALUE)
                            .addGap(42, 42, 42))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addComponent(LabelPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SelectDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DBLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SelectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IDLabel)))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Forward, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VideoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*private void LoadDirs()
    {
    	try
        {		
    	 FileInputStream fstream = new FileInputStream(System.getProperty("user.home") + File.separator + ".dbr");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         String strLine;
        
    	 while ((strLine = br.readLine()) != null)   
    	 {
    	    dbdir = strLine;
    	  }
         in.close();
         settingsdir = dbdir + ".Settings" + File.separator;
         System.out.println(settingsdir);
         }
        catch(Exception e)
        {
      	System.out.println(e.getMessage());  
         }	
    }
    
    private void LoadIndex()
    {
    	try
        {
         FileInputStream fstream = new FileInputStream(settingsdir + ".Index.index");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         String strLine;
    
         while ((strLine = br.readLine()) != null)   
         {
           PersonaIndex = strLine;
          }
         fstream.close();
         br.close();
         in.close();
         }
    	catch(Exception e)
    	{
          System.out.println("Error Settings dir not found");	
    	 }	
    }*/
    
    /*public String[] GetXMLDirs()
    { 
     try
     {
       int count = 0;
       FileInputStream fstream = new FileInputStream(xmlfiledir + ".filteredfiles.txt");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
       String strLine;
       
       while ((strLine = br.readLine()) != null)   
       {
         count++;
        }
       
       System.gc();
       
       String[] Elms = new String[count];
       FileInputStream fs = new FileInputStream(xmlfiledir + ".filteredfiles.txt");
       DataInputStream i = new DataInputStream(fs);
       BufferedReader buffer = new BufferedReader(new InputStreamReader(i));
       count = 0;
       
       while ((strLine = buffer.readLine()) != null)   
       {
         Elms[count] = strLine;
         count++;
        }
       
       in.close();
       i.close();
       return Elms;
      }
      catch (Exception e)
      {
       System.err.println("Error: " + e.getMessage());
       return null;
       }
    }*/   
    
    private int SearchURLField(String[] Attr)
    {
      int k;
   	  int result = 0;
   	  
   	  for(k=0;k<Attr.length;k++)
   	  {  
   	     if(Attr[k].contentEquals("URL"))
   	     {
   	       result = k;	 
   	     }
   	  }
   	  return result;
    }
    
    private void LoadInfo()
    {
    	Directory deletedir = new Directory(xmlfiledir);
    	deletedir.Delete(".filteredfiles.txt");
    	Directory vidir = new Directory(xmlfiledir,".xml");
    	File file = new File(xmlfiledir);
    	vidir.Read(file);
    		 
    	if(DB.contentEquals("DBGR"))
    	{			
    	 //GaitXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 GaitXMLDirs = db.GetXMLDirs(xmlfiledir); 
    	 String[][] GaitEls;
    	 int s,t;
    	 XMLFile xml = new XMLFile(GaitXMLDirs[0]);
    	 GaitEls = xml.GetElements();
    	 GaitElements = new String[GaitEls[0].length];
    	 for(s=0;s<GaitEls.length;s++)
    	 {
    	   for(t=0;t<GaitEls[s].length;t++)
    	   {
    		   GaitElements[t] = GaitEls[s][t];   
    	    }
    	  }
    	 GaitAttr = xml.Read(GaitElements);
    	 urlindex = SearchURLField(GaitElements);
    	 VideoDir = GaitAttr[0][urlindex];
    	 //System.out.println(VideoDir);
    	 try
    	 {
    	   Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 3 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
    	  }
    	 catch (Exception e)
    	 {
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
    	  }
    	 
    	 int j,k;
    	 DisplayID.setText("");
    	 for(k=0;k<GaitAttr.length;k++)
    	 {
    	   for(j=0;j<GaitAttr[k].length;j++)
    	   {
    	     if(j!=urlindex)
    	     {	 
    		   DisplayID.append(GaitElements[j] + ": " + GaitAttr[k][j] + "\n");
    	     }
    		}	  
    	  }
    		
    	 Font f =new Font("Lucida Console", 1, 12);
    	 DisplayID.setFont(f);
    	 
    	 VideoButton.setEnabled(true);
    	 Forward.setEnabled(true);
    	 Back.setEnabled(false);
    	}
    	else if(DB.contentEquals("DBFR"))
    	{	
    	 //FaceXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 FaceXMLDirs = db.GetXMLDirs(xmlfiledir);
    	 String[][] FaceEls;
    	 int s,t;
    	 //Index_Elements elm = new Index_Elements(dbdir,".Index.index", ".FaceElements.elms",".DBInitialized.db",".AllDirs", settingsdir);
    	 //FaceElements = elm.GetElements();
    	 //System.out.println(FaceXMLDirs[0]);
    	 XMLFile xml = new XMLFile(FaceXMLDirs[0]);
    	 FaceEls = xml.GetElements();
    	 FaceElements = new String[FaceEls[0].length];
    	 for(s=0;s<FaceEls.length;s++)
    	 {
    	   for(t=0;t<FaceEls[s].length;t++)
    	   {
    		   FaceElements[t] = FaceEls[s][t];   
    	    }
    	  }
    	 FaceAttr = xml.Read(FaceElements);
    	 urlindex = SearchURLField(FaceElements);
    	 VideoDir = FaceAttr[0][urlindex];
    	 //System.out.println(VideoDir);
    	 File video = new File(VideoDir);
    	 if(video.exists())
    	 {	 
    	  try
    	  {
    	    Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 1 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
    	   }
    	  catch (Exception e)
    	  {
    	    //System.out.println(e.getMessage());
    	    e.printStackTrace();
    	   }
    	  }
    	 int j,k;
    	 DisplayID.setText("");
    	 for(k=0;k<FaceAttr.length;k++)
    	 {
    	   for(j=0;j<FaceAttr[k].length;j++)
    	   {
    		 if(j!=urlindex)
      	     {
    		   DisplayID.append(FaceElements[j] + ": " + FaceAttr[k][j] + "\n");
      	     }
    		}	  
    	  }
    		
    	 Font f =new Font("Lucida Console", 1, 12);
    	 DisplayID.setFont(f);
    	 
    	 VideoButton.setEnabled(true);
    	 Forward.setEnabled(true);
    	 Back.setEnabled(false);
    	}
    	
    	int i = 0;
    	File frame = new File(xmlfiledir + "frame.jpg");
    	while(i<=20)
    	{	
    	 ImageIcon icon = new ImageIcon(xmlfiledir + "frame.jpg");
    	 icon.getImage().flush();
    	 LabelPicture.setIcon( icon );
    	 this.repaint();
    	 i++;
    	}	
    }
    
    private void Forward()
    {		 	
    	if(DB.contentEquals("DBGR"))
    	{			
    	 GaitCount++;
    	 //GaitXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 GaitXMLDirs = db.GetXMLDirs(xmlfiledir); 
    	 if(GaitCount < GaitXMLDirs.length)
         {	
    	  Back.setEnabled(true);
    	  int s,t;
    	  String[][] GaitEls;
    	  //Index_Elements elm = new Index_Elements(dbdir,".Index.index", ".GaitElements.elms",".DBInitialized.db",".AllDirs", settingsdir);
    	  //GaitElements = elm.GetElements();	 
    	  //System.out.println(GaitElements[1]);
    	  XMLFile xml = new XMLFile(GaitXMLDirs[GaitCount]);
    	  GaitEls = xml.GetElements();
    	  GaitElements = new String[GaitEls[0].length];
     	  for(s=0;s<GaitEls.length;s++)
     	  {
     	    for(t=0;t<GaitEls[s].length;t++)
     	    {
     		   GaitElements[t] = GaitEls[s][t];   
     	     }
     	   }
    	  GaitAttr = xml.Read(GaitElements);
    	  urlindex = SearchURLField(GaitElements);
    	  VideoDir = GaitAttr[0][urlindex];
    	  //System.out.println(VideoDir);
    	  File video = new File(VideoDir);
     	  if(video.exists())
     	  {
    	   try
     	   {
     	    Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 3 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
     	   }
     	   catch (Exception e)
     	   {
     	    System.out.println(e.getMessage());
     	    e.printStackTrace();
     	   }
     	  }
    	  int j,k;
    	  DisplayID.setText("");
    	  for(k=0;k<GaitAttr.length;k++)
    	  {
    	   for(j=0;j<GaitAttr[k].length;j++)
    	   {
    		 if(j!=urlindex)
      	     {
    		   DisplayID.append(GaitElements[j] + ": " + GaitAttr[k][j] + "\n");
      	     }
    		}	  
    	  }
    		
    	  Font f =new Font("Lucida Console", 1, 12);
    	  DisplayID.setFont(f);
         }
    	 else
    	 {
    		Forward.setEnabled(false); 
    	  }
    	 VideoButton.setEnabled(true);
    	}
    	else if(DB.contentEquals("DBFR"))
    	{	
    	 FaceCount++;
    	 //FaceXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 FaceXMLDirs = db.GetXMLDirs(xmlfiledir); 
    	 if(FaceCount < FaceXMLDirs.length)
    	 {
    	   Back.setEnabled(true);
       	   int s,t;
       	   String[][] FaceEls;
    	   //Index_Elements elm = new Index_Elements(dbdir,".Index.index", ".FaceElements.elms",".DBInitialized.db",".AllDirs", settingsdir);
    	   //FaceElements = elm.GetElements();
    	   //System.out.println(FaceXMLDirs[0]);
    	   XMLFile xml = new XMLFile(FaceXMLDirs[FaceCount]);
    	   FaceEls = xml.GetElements();
     	   FaceElements = new String[FaceEls[0].length];
      	   for(s=0;s<FaceEls.length;s++)
      	   {
      	     for(t=0;t<FaceEls[s].length;t++)
      	     {
      		   FaceElements[t] = FaceEls[s][t];   
      	      }
      	    }
    	   FaceAttr = xml.Read(FaceElements);
    	   urlindex = SearchURLField(FaceElements);
    	   VideoDir = FaceAttr[0][urlindex];
    	   //System.out.println(VideoDir);
    	 
    	   try
    	   {
    	     Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 1 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
    	    }
    	   catch (Exception e)
    	   {
    	     System.out.println(e.getMessage());
    	     e.printStackTrace();
    	    }
    	 
    	   int j,k;
    	   DisplayID.setText("");
    	   for(k=0;k<FaceAttr.length;k++)
    	   {
    	     for(j=0;j<FaceAttr[k].length;j++)
    	     {
    		   if(j!=urlindex)
      	       {
    		     DisplayID.append(FaceElements[j] + ": " + FaceAttr[k][j] + "\n");
      	        }
    		  }	  
    	    }
    		
    	   Font f =new Font("Lucida Console", 1, 12);
    	   DisplayID.setFont(f);
    	  }
    	 else
    	 {
    		Forward.setEnabled(false); 
    	  }
    	 VideoButton.setEnabled(true);
    	}
    	
    	int i = 0;
    	File frame = new File(xmlfiledir + "frame.jpg");
    	while(i<=20)
    	{	
    	 ImageIcon icon = new ImageIcon(xmlfiledir + "frame.jpg");
    	 icon.getImage().flush();
    	 LabelPicture.setIcon( icon );
    	 this.repaint();
    	 i++;
    	 }
    }
    
    private void Back()
    {		 	
    	if(DB.contentEquals("DBGR"))
    	{			
    	 GaitCount--;
    	 //GaitXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 GaitXMLDirs = db.GetXMLDirs(xmlfiledir); 
    	 if(GaitCount >= 0)
         {	
    	  Forward.setEnabled(true);
    	  int s,t;
    	  String[][] GaitEls;
    	  //Index_Elements elm = new Index_Elements(dbdir,".Index.index", ".GaitElements.elms",".DBInitialized.db",".AllDirs", settingsdir);
    	  //GaitElements = elm.GetElements();	 
    	  //System.out.println(GaitElements[1]);
    	  XMLFile xml = new XMLFile(GaitXMLDirs[GaitCount]);
    	  GaitEls = xml.GetElements();
    	  GaitElements = new String[GaitEls[0].length];
     	  for(s=0;s<GaitEls.length;s++)
     	  {
     	    for(t=0;t<GaitEls[s].length;t++)
     	    {
     		   GaitElements[t] = GaitEls[s][t];   
     	     }
     	   }
    	  GaitAttr = xml.Read(GaitElements);
    	  urlindex = SearchURLField(GaitElements);
    	  VideoDir = GaitAttr[0][urlindex];
    	  //System.out.println(VideoDir);
    	  File video = new File(VideoDir);
     	  if(video.exists())
     	  {
    	   try
     	   {
     	    Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 3 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
     	   }
     	   catch (Exception e)
     	   {
     	    System.out.println(e.getMessage());
     	    e.printStackTrace();
     	   }
     	  }
    	  int j,k;
    	  DisplayID.setText("");
    	  for(k=0;k<GaitAttr.length;k++)
    	  {
    	   for(j=0;j<GaitAttr[k].length;j++)
    	   {
    		 if(j!=urlindex)
      	     {
    		   DisplayID.append(GaitElements[j] + ": " + GaitAttr[k][j] + "\n");
      	     }
    		}	  
    	  }
    		
    	  Font f =new Font("Lucida Console", 1, 12);
    	  DisplayID.setFont(f);
         }
    	 else
    	 {
    		Back.setEnabled(false); 
    	  }
    	 VideoButton.setEnabled(true);
    	}
    	else if(DB.contentEquals("DBFR"))
    	{	
    	 FaceCount--;
    	 //FaceXMLDirs = GetXMLDirs();
    	 DBR db = new DBR(); //Creates an instance of DBR class
    	 FaceXMLDirs = db.GetXMLDirs(xmlfiledir); 
    	 if(FaceCount >= 0)
         {	
    	   Forward.setEnabled(true);
    	   int s,t;
    	   String[][] FaceEls;
    	   //Index_Elements elm = new Index_Elements(dbdir,".Index.index", ".FaceElements.elms",".DBInitialized.db",".AllDirs", settingsdir);
    	   //FaceElements = elm.GetElements();
    	   //System.out.println(FaceXMLDirs[0]);
    	   XMLFile xml = new XMLFile(FaceXMLDirs[FaceCount]);
    	   FaceEls = xml.GetElements();
     	   FaceElements = new String[FaceEls[0].length];
      	   for(s=0;s<FaceEls.length;s++)
      	   {
      	    for(t=0;t<FaceEls[s].length;t++)
      	    {
      		   FaceElements[t] = FaceEls[s][t];   
      	      }
      	    }
    	   FaceAttr = xml.Read(FaceElements);
    	   urlindex = SearchURLField(FaceElements);
    	   VideoDir = FaceAttr[0][urlindex];
    	   //System.out.println(VideoDir);
    	   try
    	   {
    	     Process proc1 = Runtime.getRuntime().exec("ffmpeg -vframes 1 -ss 1 -i " + VideoDir + " " + xmlfiledir + "frame.jpg");
    	    }
    	   catch (Exception e)
    	   {
    	     System.out.println(e.getMessage());
    	     e.printStackTrace();
    	    }
    	 
    	   int j,k;
    	   DisplayID.setText("");
    	   for(k=0;k<FaceAttr.length;k++)
    	   {
    	     for(j=0;j<FaceAttr[k].length;j++)
    	     {
    		   if(j!=urlindex)
      	       {
    		     DisplayID.append(FaceElements[j] + ": " + FaceAttr[k][j] + "\n");
      	        }
    		  }	  
    	    }
    		
    	   Font f =new Font("Lucida Console", 1, 12);
    	   DisplayID.setFont(f);
    	 }
   	    else
   	    {
   		  Back.setEnabled(false); 
   	     }
    	 VideoButton.setEnabled(true);
    	}
    	
    	int i=0;
    	File frame = new File(xmlfiledir + "frame.jpg");
    	while(i<=20)
    	{	
    	 ImageIcon icon = new ImageIcon(xmlfiledir + "frame.jpg");
    	 icon.getImage().flush();
    	 LabelPicture.setIcon( icon );
    	 this.repaint();
    	 i++;
    	}
    }
    
private void SelectIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectIDActionPerformed
// TODO add your handling code here:
	ID = SelectID.getSelectedItem().toString();
	System.out.println(ID);
	xmlfiledir = dbdir + DB + File.separator + "P" + ID + File.separator;
	LoadInfo();
	//System.out.println(xmlfiledir);
}//GEN-LAST:event_SelectIDActionPerformed

private void SelectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectDBActionPerformed
// TODO add your handling code here:
	DB = SelectDB.getSelectedItem().toString();
	System.out.println(DB);
	xmlfiledir = dbdir + DB + File.separator + "P" + ID + File.separator;
	LoadInfo();
	//System.out.println(xmlfiledir + "P1.xml");
}//GEN-LAST:event_SelectDBActionPerformed

private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
// TODO add your handling code here:
	Back();
}//GEN-LAST:event_BackActionPerformed

private void ForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForwardActionPerformed
// TODO add your handling code here:
	Forward();
}//GEN-LAST:event_ForwardActionPerformed

private void VideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VideoButtonActionPerformed
// TODO add your handling code here:
  File f = new File(VideoDir);
  if(f.exists())
  {	  
	/*try
	{
	 PlayVideo playvideo = new PlayVideo(VideoDir);
	 playvideo.PlaySingle();
	 //Process proc = Runtime.getRuntime().exec("vlc " + VideoDir);
	 VideoButton.setEnabled(false);
	}
	catch(Exception e)
	{
	 e.printStackTrace();
	}*/
	    try
		{
		 Process proc = Runtime.getRuntime().exec("vlc " + VideoDir);
		 VideoButton.setEnabled(false);
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}  
  }
  else
  {
	 //JOptionPane.showMessageDialog(null, "Video not found", "Video",JOptionPane.ERROR_MESSAGE);
	 VideoButton.setEnabled(false);
  }	  
}//GEN-LAST:event_VideoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
	 * @uml.property  name="back"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JButton Back;
    /**
	 * @uml.property  name="dBLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JLabel DBLabel;
    /**
	 * @uml.property  name="displayID"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JTextArea DisplayID;
    /**
	 * @uml.property  name="forward"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JButton Forward;
    /**
	 * @uml.property  name="iDLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JLabel IDLabel;
    /**
	 * @uml.property  name="labelPicture"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JLabel LabelPicture;
    /**
	 * @uml.property  name="selectDB"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JComboBox SelectDB;
    /**
	 * @uml.property  name="selectID"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JComboBox SelectID;
    /**
	 * @uml.property  name="videoButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JButton VideoButton;
    /**
	 * @uml.property  name="jScrollPane1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
