package android.saikiranpro.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.co.gauravtiwari.voice.client.VoiceAutomationClient;
import in.co.gauravtiwari.voice.clientresources.ClientOperationException;
import in.co.gauravtiwari.voice.clientresources.Voice;
import in.co.gauravtiwari.voice.design.Language;

public class VoiceTest {
    public static void main(String[] args){
        textToSpeechTest();
        playInternetVoiceFile();
    }

    public static void textToSpeechTest(){
        final Logger LOG = LoggerFactory.getLogger(VoiceTest.class);
        //Start the server on your target machine by command java -jar VoiceAuotmationServer.jar
        System.setProperty("VoiceAutomationServerEndpoint","http://192.168.120.67:9090");
        //Signup to voicerss and get your api key
        System.setProperty("VoiceRssKey","<your api key>");
        Voice voice = new Voice("Hey Google, whats the current time", Language.ENGLISH_US);

        try {
            VoiceAutomationClient voiceAutomationClient = new VoiceAutomationClient();
            voiceAutomationClient.load(voice);
            voiceAutomationClient.play(voice);
            LOG.info(voice.getFilename());
            LOG.info(voice.getText());
            LOG.info(voice.getVoiceName());
            LOG.info(voice.getVoiceLanguage().toString());
        }catch (ClientOperationException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void playInternetVoiceFile(){
        final Logger LOG = LoggerFactory.getLogger(VoiceTest.class);
        //Start the server on your target machine by command java -jar VoiceAuotmationServer.jar
        System.setProperty("VoiceAutomationServerEndpoint","http://192.168.120.67:9090");
        //Signup to voicerss and get your api key
        System.setProperty("VoiceRssKey","<your api key>");
        Voice voice = new Voice("http://www.pacdv.com/sounds/voices/thank-god-its-friday.wav");

        try {
            VoiceAutomationClient voiceAutomationClient = new VoiceAutomationClient();
            voiceAutomationClient.load(voice);
            voiceAutomationClient.play(voice);
            LOG.info(voice.getFilename());
            LOG.info(voice.getText());
            LOG.info(voice.getVoiceName());
            LOG.info(voice.getVoiceLanguage().toString());
        }catch (ClientOperationException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
