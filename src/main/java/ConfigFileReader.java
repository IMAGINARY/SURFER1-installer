import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Map;

public class ConfigFileReader {

	public static void applyUserSettings()
		throws Exception
	{
		Properties p = new Properties();

	    String userHome = System.getProperty("user.home");
    	if(userHome == null) {
        	throw new IllegalStateException("user.home==null");
    	}
    	File home = new File(userHome);
    	File settingsFile = new File(home, ".fxsurfer");
    	if(!settingsFile.exists()) {
        	if(!settingsFile.createNewFile()) {
            	throw new IllegalStateException(settingsFile.toString());
        	}
        	p.setProperty( "de.mfo.jsurfer.gui.showPrintButton", "false" );
			p.setProperty( "de.mfo.jsurfer.gui.showLoadSaveButton", "true" );
			p.setProperty( "de.mfo.jsurfer.gui.showExportButton", "true" );
			p.setProperty( "de.mfo.jsurfer.gui.hideCursor", "false" );
			p.setProperty( "de.mfo.jsurfer.gui.fullscreen", "false" );
			
			FileWriter w = new FileWriter( settingsFile );
			p.store( w, "Settings for SURFER 1" );
			
			w.write( "\n" );
			w.write( "# disable or reorder languages by uncommenting and editing the following property\n" );
			w.write( "# de.mfo.jsurfer.gui.languages=es,de,en,pt,ru,sr\n" );

			w.write( "\n" );
			w.write( "# the click mode is useful for fine tuning button events for touchscreens:\n" );
			w.write( "#     0: use \"mouse click\" event (default)\n" );
			w.write( "#     1: use \"mouse pressed\" event\n" );
			w.write( "#     2: use \"mouse released\" event\n" );
			w.write( "# de.mfo.jsurfer.gui.clickMode=1\n" );
			w.close();
   		}
   		else
   		{
   			p.load( new FileReader( settingsFile ) );
   		}
   		for( Map.Entry< Object, Object > kv : p.entrySet() )
   			System.setProperty( ( String ) kv.getKey(), ( String ) kv.getValue() );
	}

    public static void main(String[] args)
    {
   		try
    	{
    		applyUserSettings();
    	}
    	catch( Exception e )
    	{
    		System.err.println( "unable to load user settings:" + e );
    	}
    	de.mfo.jsurfer.Main.main( args );
    }
}