package edu.lsivc.directory;

import java.io.*;

public class MovingFiles
{
  public MovingFiles()
  {
	  
   }
   
  public void copyDirectory(File sourceDir, File destDir) throws IOException
  {
     if(!destDir.exists())
     {
       destDir.mkdir();
      }

     File[] children = sourceDir.listFiles();
     for(File sourceChild : children)
     {
       String name = sourceChild.getName();
       File destChild = new File(destDir, name);
       if(sourceChild.isDirectory())
       {
         copyDirectory(sourceChild, destChild);
        }
       else
       {
         copyFile(sourceChild, destChild);
        }
      }
    }
   
   private void copyFile(File source, File dest) throws IOException
   {
     if(!dest.exists())
     {
       dest.createNewFile();
      }
     InputStream in = null;
     OutputStream out = null;

    try
    {
      in = new FileInputStream(source);
      out = new FileOutputStream(dest);
      byte[] buf = new byte[1024];
      int len;
      while((len = in.read(buf)) > 0)
      {
        out.write(buf, 0, len);
       }
     }
    finally
    {
      in.close();
      out.close();
     }
   }

   public boolean delete(File resource) throws IOException
   { 
     if(resource.isDirectory())
     {
       File[] childFiles = resource.listFiles();
       for(File child : childFiles)
       {
        delete(child);
        }
      }
     return resource.delete();
   }
 }
