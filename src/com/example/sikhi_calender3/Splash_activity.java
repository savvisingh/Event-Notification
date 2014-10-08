package com.example.sikhi_calender3;

import java.sql.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class Splash_activity extends  Activity {
	 final int Sangrandh=1, Masya=2 , PuranMashi=3 ,Gurpurab=4,Historical_days=5,Other_Events=6; 
	 Intent service_intent; 
	 private CharSequence mDrawerTitle="Nanakshahi Calender";
	 private ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		ActionBar bar = getActionBar();
		  bar.setBackgroundDrawable(new ColorDrawable(0xff6fb7ea));
		  bar.setIcon(R.drawable.khanda_light_blue);
		  bar.setTitle(mDrawerTitle);
		  progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		  progressBar.setProgress(10);
		Thread initial = new Thread() {
			
			public void run() {
				
				try {
					
					sleep(1000);
					progressBar.setProgress(15);
					 DataBase_Handler db1 = new DataBase_Handler(getApplicationContext());
		                
		          	   if( db1.check_database())
		          	   {
		       		  
		db1.add_event(new Event("Sangrandh (Beginning of the Chet ) ", "", " Gursikhi Event", 3, 14,Sangrandh,2014));
		db1.add_event(new Event("Nanakshahi New Year Day ", "", " Gursikhi Event", 3, 14,Historical_days,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru Har Rai Sahib Ji (The Seventh Guru) ", "", " Gursikhi Event", 3, 14,Gurpurab,2014));
		db1.add_event(new Event("Sr. Baghel Singh's conquest of Delhi", "", " Gursikhi Event", 3, 15,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 3,16,PuranMashi,2014));
		db1.add_event(new Event("Hola Mahalla (Hola Mohalla or Hola)", "", " Gursikhi Event", 3, 17,Historical_days,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru HarGobind Sahib Ji (The Sixth Guru)", "", " Gursikhi Event", 3, 19,Gurpurab,2014));
		progressBar.setProgress(20);
		db1.add_event(new Event("Shaheedi (Martyrdom) Sr. Bhagat Singh", "", " Gursikhi Event", 3, 23,Historical_days,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Subeg Singh, Bhai Shahbaz Singh", "", " Gursikhi Event", 3, 25,Historical_days,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 3, 30,Masya,2014));
		db1.add_event(new Event("Ram Navami (Birth of Lord Ram)", "", "Government Holidays", 4, 8,Other_Events,2014));
		db1.add_event(new Event("Janam (Birth) Sahibzada Jujhar Singh Ji (Second of Guru Gobind Singh's four sons)", "", " Gursikhi Event", 4, 9,Historical_days,2014));
		db1.add_event(new Event("Sikh Turban Day", "", " Gursikhi Event", 4, 9,Historical_days,2014));
		db1.add_event(new Event("Mahavir Jayanti (Birth of Lord Mahavir)", "", " Government Holidays", 4, 9,Other_Events,2014));
		progressBar.setProgress(25);
		db1.add_event(new Event("Sangrandh (Beginning of the Vaisakh) ", "", " Gursikhi Event", 4, 14,Sangrandh,2014));
		db1.add_event(new Event("Vaisakhi (Birth Anniversary of Khalsa)", "", " Gursikhi Event", 4, 14,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Dr B. R. Ambedkar", "", "Govenment Holidays", 4, 14,Other_Events,2014));
		db1.add_event(new Event("PuranMashi (FullMoon Day)", "", " Gursikhi Event", 4,15,PuranMashi,2014));
		db1.add_event(new Event("GurtaGadi(Guruship) Guru Amar Das Sahib Ji (The Third Guru)", "", " Gursikhi Event", 4, 16,Gurpurab,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru Angad Dev Ji (The Second Guru)", "", " Gursikhi Event", 4, 16,Gurpurab,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru Tegh Bahadur Sahib Ji (The Ninth Guru)", "", " Gursikhi Event", 4, 16,Gurpurab,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru Harkrishan Sahib Ji (The Eight Guru)", "", " Gursikhi Event", 4, 16,Gurpurab,2014));
		progressBar.setProgress(30);
		db1.add_event(new Event("Prakash (Birth) Guru Angad Dev Ji (The Second Guru)", "", " Gursikhi Event", 4, 18,Gurpurab,2014));
		db1.add_event(new Event("Prakash (Birth) Guru Tegh Bahadur Sahib Ji (The Ninth Guru)", "", " Gursikhi Event", 4, 18,Gurpurab,2014));
		db1.add_event(new Event("Goor Friday", "", "Government Holidays", 4, 21,Other_Events,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 4, 29,Masya,2014));
		db1.add_event(new Event("Labour Day", "", "Government Holidays", 5, 1,Other_Events,2014));
		db1.add_event(new Event("Parshuram Jayanti (Birth of Lord Parshuram) ", "", "Government Holidays", 5, 1,Other_Events,2014));
		db1.add_event(new Event("Prakash (Birth) Guru Arjun Dev Ji (The Fifth Guru)", "", " Gursikhi Event", 5, 2,Gurpurab,2014));
		progressBar.setProgress(35);
		db1.add_event(new Event("Shaheedi (Martyrdom) Chali Mukte (40 Sikh Warriors)", "", " Gursikhi Event", 5, 4,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 5,14,PuranMashi,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Jeth) ", "", " Gursikhi Event", 5, 14,Sangrandh,2014));
		db1.add_event(new Event("Sirhind Fateh Diwas (Victory Day)", "", " Gursikhi Event", 5, 14,Historical_days,2014));
		db1.add_event(new Event("Buddha Purnima (Birth of Lord Buddha)", "", "Government Holidays", 5, 14,Other_Events,2014));
		db1.add_event(new Event("Chhota Ghallughara (Holocast)", "", " Gursikhi Event", 5, 17,Historical_days,2014));
		db1.add_event(new Event("Saka (Massacre) Paonta Sahib", "", " Gursikhi Event", 5, 22,Historical_days,2014));
		db1.add_event(new Event("Prakash (Birth) Guru Amar Das Sahib Ji (The Third Guru) ", "", " Gursikhi Event", 5,23,Gurpurab,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 5, 28,Masya,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Guru Arjun Dev Ji (The Fifth Guru)", "", " Gursikhi Event", 6, 1,Gurpurab,2014));
		progressBar.setProgress(40);
		db1.add_event(new Event("1984 Ghallughara (Attack on Sri Akal Takht Sahib)", "", " Gursikhi Event", 6, 4,Historical_days,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Sant Baba Jarnail Singh Ji ", "", " Gursikhi Event", 6, 6,Historical_days,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Amrik Singh Ji", "", " Gursikhi Event", 6, 6,Historical_days,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru HarGobind Sahib Ji (The Sixth Guru) ", "", " Gursikhi Event", 6, 11,Gurpurab,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 6,13,PuranMashi,2014));
		db1.add_event(new Event("Jor Mela Gurdwara Reetha Sahib (Uttrakhand)", "", " Gursikhi Event", 6, 13,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Bhagat Kabir Ji", "", " Gursikhi Event", 6, 13,Historical_days,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Harh) ", "", " Gursikhi Event", 6, 15,Sangrandh,2014));
		
		progressBar.setProgress(45);
		db1.add_event(new Event("Shaheedi (Martyrdom) Baba Banda Singh Ji Bahadur ", "", " Gursikhi Event", 6, 25,Historical_days,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 6, 27,Masya,2014));
		db1.add_event(new Event("Barsi (Death anniversary) Maharaja Ranjit Singh Ji ", "", " Gursikhi Event", 6, 29,Historical_days,2014));
		db1.add_event(new Event("The Foundation Day of Sri Akal Takht Sahib (Throne of the timeless God )", "", " Gursikhi Event", 7, 2,Historical_days,2014));
		db1.add_event(new Event("Prakash (Birth) Guru HarGobind Sahib Ji (The Sixth Guru)", "", " Gursikhi Event", 7, 5,Gurpurab,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Mani Singh Ji ", "", " Gursikhi Event", 7, 9,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 7,12,PuranMashi,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Sawan) ", "", " Gursikhi Event", 7, 16,Sangrandh,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Taru Singh Ji", "", " Gursikhi Event", 7, 16 ,Historical_days,2014));
		db1.add_event(new Event("Miri Piri Diwas Sixth Guru ('Miri' The Sword of Military Power , 'Piri' The Sword of Spiritual Power ) ", "", " Gursikhi Event", 7, 21,Gurpurab,2014));
		db1.add_event(new Event("Prakash (Birth) Guru Harkrishan Sahib Ji (The Eight Guru)", "", " Gursikhi Event", 7, 23,Gurpurab,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 7, 26,Masya,2014));
		db1.add_event(new Event("Eid Al Fitr", "", "Govenment Holidays", 7, 29,Other_Events,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Sr. Udham Singh", "", "Govenment Holidays", 7, 31,Historical_days,2014));
		progressBar.setProgress(50);
		db1.add_event(new Event("Morcha (Agitation) Guru Ka Bagh ", "", "Gursikhi Event", 8, 8,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 8,10,PuranMashi,2014));
		db1.add_event(new Event("Jor Mela (Fair) Baba Bakala (Amritsar)", "", "Gursikhi Event", 8, 10,Historical_days,2014));
		db1.add_event(new Event("Independence Day", "", "Govenment Holidays", 8, 15,Other_Events,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Bhadon) ", "", " Gursikhi Event", 8, 17,Sangrandh,2014));
		db1.add_event(new Event("Sri Krishna Janmashtami (Birth of Lord Krishna) ", "", "Govenment Holidays", 8, 17,Other_Events,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 8, 25,Masya,2014));
		db1.add_event(new Event("Compilation of Sri Guru Granth Sahib Ji", "", "Gursikhi Event", 8, 30,Gurpurab,2014));
		db1.add_event(new Event("First Parkash of Shri Guru Granth Sahib Ji", "", "Gursikhi Event", 9, 1,Gurpurab,2014));
		db1.add_event(new Event("Jor Mela (Fair) Kandh Sahib ,Batala ", "", "Gursikhi Event", 9, 1,Gurpurab,2014));
		db1.add_event(new Event("Janam (Birth) Baba Shri Chand Ji", "", "Gursikhi Event", 9, 3,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 9, 9,PuranMashi,2014));
		
		progressBar.setProgress(55);
		db1.add_event(new Event("Barsi (Death anniversary) Baba Budda Ji", "", "Gursikhi Event", 9, 13,Historical_days,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Asu month) ", "", " Gursikhi Event", 9, 16,Sangrandh,2014));
		db1.add_event(new Event("GurtaGadi(Guruship) Guru Ramdass Sahib Ji (The Fourth Guru)", "", " Gursikhi Event", 9, 16,Gurpurab,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru Amardas Sahib Ji (The Third Guru)", "", " Gursikhi Event", 9, 16,Gurpurab,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru Arjan Dev Ji (The Fifth Guru)", "", " Gursikhi Event", 9, 16,Gurpurab,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru Ramdass Sahib Ji (The Fourth Guru)", " ", " Gursikhi Event", 9, 16,Gurpurab,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru Angad Dev Ji (The Second Guru)", "", " Gursikhi Event", 9, 18,Gurpurab,2014));
		db1.add_event(new Event("JotiJot (Left for heavenly abode) Guru Nanak Dev Ji (The First Guru)", "", " Gursikhi Event", 9, 22,Gurpurab,2014));
		
		progressBar.setProgress(60);
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 9, 24,Masya,2014));
		db1.add_event(new Event("Janam (Birth) Sardar Bhagat singh", "", " Gursikhi Event", 9, 28,Gurpurab,2014));
		db1.add_event(new Event("The Foundation Day of Singh Sabha (Society of the Singhs)", "", " Gursikhi Event", 10, 1,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Mahatma Gandhi and Shri Lal Bhadur Shastri", "", "Govenment Holidays", 10, 2,Other_Events,2014));
		db1.add_event(new Event("Durgashtami (Durga Ashtami)", "", " Govenment Holidays", 10, 2,Other_Events,2014));
		db1.add_event(new Event("Darbar Khalsa (Dussehra). ", "", " Gursikhi Event", 10, 3,Historical_days,2014));
		db1.add_event(new Event("Jor Mela Baba Budha (Thatha) ", "", " Gursikhi Event", 10, 6,Historical_days,2014));          	   
		db1.add_event(new Event("Eid al Adha ", "", "Govenment Holidays", 10,6,Other_Events,2014)); 
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 10,8,PuranMashi,2014));
		db1.add_event(new Event("Janam (Birth) MahaRishi Valmiki", "", "Govenment Holidays ", 10, 8,Other_Events,2014));
		db1.add_event(new Event("Prakash (Birth) Shri Guru Ramdass Ji", "", " Gursikhi Event", 10, 9,Gurpurab,2014));
		progressBar.setProgress(65);
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Sukhdev Singh (Sukha), Bhai Harjinder Singh (Jinda)", "", " Gursikhi Event", 10, 9,Historical_days,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Katak month) ", "", " Gursikhi Event", 10, 17,Sangrandh,2014));
		db1.add_event(new Event("GurtaGadi(Guruship) Guru Har Krishan ji (The Eight Guru)", "", " Gursikhi Event", 10, 20,Gurpurab,2014));
		db1.add_event(new Event("Joti Jot (Left for heavenly abode) Guru HarRai Ji (The Seventh Guru)", "", " Gursikhi Event",10, 20,Gurpurab,2014));
		db1.add_event(new Event("Janam (Birth) Giani Kartar Singh Bhindranwale", "", " Gursikhi Event", 10, 21,Historical_days,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 10, 23,Masya,2014));
		db1.add_event(new Event("Janam (Birth) Baba Budha Ji (Kathunangal)", "", "Gursikhi Event", 10,23,Historical_days,2014)); 
		db1.add_event(new Event("Bandi Choor Diwas (Diwali)", "", "Gursikhi Event", 10,23,Historical_days,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Shri Guru Granth Sahib Ji (The Eleventh Guru)  ", "", "Gursikhi Event", 10,25,Gurpurab,2014));
		db1.add_event(new Event("Vishwakarma Day", "", "Govenment Holidays", 10,25,Other_Events,2014));		
		db1.add_event(new Event("Joti Jot (Left for heavenly abode) Guru Gobind Singh Ji (The Tenth Guru)", "", "Gursikhi Event", 10,28,Gurpurab,2014));
		db1.add_event(new Event("The Foundation Day of Chief Khalsa Diwan (Sikh organisation) ", "", "Gursikhi Event", 10,28,Historical_days,2014));
		
		progressBar.setProgress(70);
		db1.add_event(new Event("Saka (Massacre) Panja Sahib", "", "Gursikhi Event", 10,28,Historical_days,2014));
		db1.add_event(new Event("Shaheedi(Martyrdom) Bhai Baint Singh", "", "Gursikhi Event", 10,31,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Mata Sahib Kaur (Mother of Khalsa)", "", "Gursikhi Event", 11,1,Historical_days,2014));
		db1.add_event(new Event("Punjabi Suba Divas", "", "Gursikhi Event", 11,1,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Bhagat Namdev", "", "Gursikhi Event", 11,3,Historical_days,2014));
		db1.add_event(new Event("Muharram (First month of the Islamic calendar) Tazia", "", "Govenment Holidays", 11,4,Other_Events,2014));
		db1.add_event(new Event("Prakash (Birth) Shri Guru Nanak Dev Ji (The First Guru)", "", "Gursikhi Event", 11,6,Gurpurab,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 11,6,PuranMashi,2014));		
		db1.add_event(new Event("Jor Mela Achal Sahib (Batala) ", "", "Gursikhi Event", 11,11,Historical_days,2014));
		db1.add_event(new Event("Shaheedi(Martyrdom) Baba Deep Singh Ji", "", "Gursikhi Event", 11,13,Historical_days,2014));
		db1.add_event(new Event("The Foundation Day of SGPC (Shiromani Gurdwara Parbandhak Committee) ", "", "Gursikhi Event", 11,14,Historical_days,2014));
		progressBar.setProgress(75);
		db1.add_event(new Event("Children's Day (Birth of Jawaharlal Nehru) ", "", "Govenment Holidays", 11,14,Other_Events,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Maghar month) ", "", " Gursikhi Event", 11, 16,Sangrandh,2014));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 11, 22,Masya,2014));
		db1.add_event(new Event("GurtaGadi (Guruship) Guru Gobind Singh Ji (The Tenth Guru)", "", "Gursikhi Event", 11,24,Gurpurab,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Mati Das ji, Bhai Sati Das ji, Bhai Dhayala ji. ", "", "Gursikhi Event", 11,24,Historical_days,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Guru Teg Bhadur Sahib Ji ( The Ninth Guru) ", "", "Gursikhi Event", 11,24,Gurpurab,2014));
		db1.add_event(new Event("Janam (Birth) Sahibzada Zorawar Singh Ji  (Third of Guru Gobind Singh's four sons) ", "", "Gursikhi Event", 11,28,Historical_days,2014));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 12,6,PuranMashi,2014));
		db1.add_event(new Event("Janam (Birth) Sahibzada Fateh Singh Ji  (The youngest of Guru Gobind Singh's four sons) ", "", "Gursikhi Event", 12,12,Historical_days,2014));
		db1.add_event(new Event("The Foundation Day of Shiromani Akali Dal", "", "Gursikhi Event", 12,13,Historical_days,2014));
		db1.add_event(new Event("Sangrandh (Beginning of the Poh month) ", "", " Gursikhi Event", 12, 16,Sangrandh,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Baba Gurbaksh Singh Ji", "", "Gursikhi Event", 12,17,Historical_days,2014));
		
		progressBar.setProgress(80);
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 12, 21,Masya,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Sahibzada Ajit Singh & Jujhar Singh (Guru Gobind Singh's Eldest two sons) and other Shaheeds of Chamkaur Sahib ", "", "Gursikhi Event", 12,21,Historical_days,2014));
		db1.add_event(new Event(" Shaheedi (Martyrdom) Bhai Jeevan Singh Ji  ", "", "Gursikhi Event", 12,21,Historical_days,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Sangat Singh Ji ", "", "Gursikhi Event", 12,22,Historical_days,2014));
		db1.add_event(new Event("Christmas Day ", "", "Govenment Holidays", 12,25,Other_Events,2014));
		db1.add_event(new Event("Shaheedi (Martyrdom) Sahibzada Zorawar Singh & Fateh Singh (Guru Gobind Singh's Youngest two sons) and Mata Gujri Ji", "", "Gursikhi Event", 12,26,Historical_days,2014));
		db1.add_event(new Event("Janam (Birth) Shaheed Udham Singh Ji  ", "", "Gursikhi Event", 12,26,Historical_days,2014));
		db1.add_event(new Event("Prakash (Birth) Guru Gobind Singh Ji (The Tenth Guru) ", "", "Gursikhi Event", 12,28,Gurpurab,2014));
		
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 1,5,PuranMashi,2015)); 
		db1.add_event(new Event("Shaheedi (Martyrdom) Bhai Kehar Singh and Bhai Satwant Singh", "", "Gursikhi Event", 1, 6,Historical_days,2015));
		db1.add_event(new Event("Initiation of the construction of the Darbar Sahib (Golden Temple)", " ", " Gursikhi Event", 1, 13,Historical_days,2015));
		db1.add_event(new Event("Sangrandh (Beginning of the Magh) ", "", " Gursikhi Event", 1, 14,Sangrandh,2015));
		db1.add_event(new Event("Jor Mela Muktsar (Maghi fair)", " ", "Gursikhi Event ", 1, 14,Historical_days,2015));
		db1.add_event(new Event("Chabian da Morcha ", " ", " Gursikhi Event", 1, 19,Historical_days,2015));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 1, 20,Masya,2015));
		db1.add_event(new Event("Janam (Birth) Shaheed Baba Deep Singh ji ", "", " Gursikhi Event", 1, 26,Historical_days,2015));
		progressBar.setProgress(85);
		db1.add_event(new Event("Prakash (Birth) Guru Har Rai Ji (The Seventh Guru)","",  " Gursikhi Event", 1, 31,Gurpurab,2015));
		db1.add_event(new Event("Janam (Birth) Bhagat Ravidas Ji", "", " Gursikhi Event", 2, 3,Gurpurab,2015));
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 2,3,PuranMashi,2015)); 
		db1.add_event(new Event("Jor Mela Kotha Sahib (Wallan)", " ", "martyr Gursikhi Event", 2, 6,Historical_days,2015));
		db1.add_event(new Event("Wadda Ghallughara (Great Holocast) ", "", " Gursikhi Event", 2, 8,Historical_days,2015));
		db1.add_event(new Event("Janam (Birth) Sahibzada Ajit Singh (The eldest of Guru Gobind Singh's four sons)", "", " Gursikhi Event", 2, 11,Historical_days,2015));
		db1.add_event(new Event("Sangrandh (Beginning of the Phagun ) ", "", " Gursikhi Event", 2, 13,Sangrandh,2015));
		db1.add_event(new Event("Maha Shivratri", "", "Govenment Holidays", 2, 17,Other_Events,2015));
		db1.add_event(new Event("Masya (No Moon Day)", "", " Gursikhi Event", 2, 18,Masya,2015));
		db1.add_event(new Event("Saka (Massacre) Nankana Sahib", "", " Gursikhi Event", 2, 21,Historical_days,2015));
		db1.add_event(new Event("Jaiton da Morcha (Agitation of Jaiton)", "", " Gursikhi Event", 2, 21,Historical_days,2015)); 
		db1.add_event(new Event("PuranMashi  (FullMoon Day)", "", " Gursikhi Event", 3,5,PuranMashi,2015));
		db1.add_event(new Event("Hola Mahalla (Hola Mohalla or Hola)", "", " Gursikhi Event", 3, 6,Historical_days,2015));
		db1.add_event(new Event("International Women Day (IWD)", "", "Government Holidays", 3, 8,Other_Events,2015));
		progressBar.setProgress(90);
			

		          	   
		          	   
		
		          	   
		          	   }
		          	   
		          	   
		          	 long eventmillisec,currentmillisec;
		    		 Event event=db1.get_event();
		    		 int date= event.getdate();
		      		 int month = event.getmonth();
		    		 Date time= new Date(114, month-1,date);
		    		 eventmillisec =time.getTime();
		    		 currentmillisec =System.currentTimeMillis();
		    		 int id=event.getID();
		    		
		    		  while (eventmillisec<currentmillisec)
		    		{  
		    			 
		    			 db1.setstatus(id);
		    			 event=db1.get_event();
		    			 id=event.getID();
		    		    date= event.getdate();
		       		  month = event.getmonth();
		    		  time= new Date(114, month-1,date);
		    		 eventmillisec =time.getTime();
		    		 currentmillisec =System.currentTimeMillis();
		    		 	
		    		};
		    		
		    		progressBar.setProgress(95);
		          	 service_intent=new Intent(getApplicationContext(),Start_Service.class);		
					 
		 	      startService(service_intent);	   
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					progressBar.setProgress(100);
					Intent home = new Intent(Splash_activity.this,
							MainActivity.class);
					home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(home);

				}

			}

		};
		initial.start();
	}
	

}
