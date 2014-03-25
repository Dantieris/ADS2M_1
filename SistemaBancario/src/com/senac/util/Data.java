package com.senac.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Data
{
    private String mes
    , ano
    , dia
    , dia_semana
    , hora;
    
    SimpleDateFormat horaFormatada;
    
    public Data()
    {
    	horaFormatada = new SimpleDateFormat("HH:mm:ss");
    }
    
    public String getMes() 
    {
		return mes;
	}

	public void setMes(String mes) 
	{
		this.mes = mes;
	}

	public String getAno() 
	{
		return ano;
	}

	public void setAno(String ano) 
	{
		this.ano = ano;
	}

	public String getDia() 
	{
		return dia;
	}

	public void setDia(String dia) 
	{
		this.dia = dia;
	}

	public String getDia_semana() 
	{
		return dia_semana;
	}

	public void setDia_semana(String dia_semana) 
	{
		this.dia_semana = dia_semana;
	}

	public String getHora() 
	{
		return hora;
	}

	public void setHora(String hora) 
	{
		this.hora = hora;
	}

	public SimpleDateFormat getHoraFormatada() 
	{
		return horaFormatada;
	}

	public void setHoraFormatada(SimpleDateFormat horaFormatada) 
	{
		this.horaFormatada = horaFormatada;
	}

	//recebe a hora atual.
	public void recebeHora()
    {
       Date hora = new Date();
       
       setHora( getHoraFormatada().format( hora ) );
    }
    
    //recebe a data atual.
    public void recebeData()
    {
        Date data = new Date();
        
        dia 		= "" + data.getDate();
        ano 		= "" + ( 1900 + data.getYear() );
        dia_semana 	= "" + data.getDay();
        
        switch (data.getDay())
        {
        
            case 0  : dia_semana = "domingo";  		break;
            case 1  : dia_semana = "segunda-feira"; break;
            case 2  : dia_semana = "terça-feira";  	break;
            case 3  : dia_semana = "quarta-feira";  break;
            case 4  : dia_semana = "quinta-feira";  break;
            case 5  : dia_semana = "sexta-feira";  	break;
            case 6  : dia_semana = "sábado";  		break;
            default : dia_semana = "desconhecido";	break;
            
        }
        
        switch (data.getMonth())
        {
        
            case 0  : mes = "Janeiro";  	break;
            case 1  : mes = "Fevereiro";  	break;
            case 2  : mes = "Março";  		break;
            case 3  : mes = "Abril";  		break;
            case 4  : mes = "Maio";  		break;
            case 5  : mes = "Junho";  		break;
            case 6  : mes = "Julho";  		break;
            case 7  : mes = "Agosto";  		break;
            case 8  : mes = "Setembro";  	break;
            case 9  : mes = "Outubro";  	break;
            case 10 : mes = "Novembro"; 	break;
            case 11 : mes = "Dezembro"; 	break;
            default : mes = "desconhecido"; break;
            
        }
    }
   
    //retorna a data atual no formato
    //dd/mm/aaaa.
    public String recebeDataCompacta()
	{
		Date data = new Date();
		
		String dataCriacao = data.getDate() + "/" + ( data.getMonth() + 1 ) + "/" + ( data.getYear() + 1900 );
		
		return dataCriacao;
	}
}