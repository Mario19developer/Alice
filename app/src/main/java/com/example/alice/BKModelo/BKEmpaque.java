package com.example.alice.BKModelo;

import java.util.Objects;

public class BKEmpaque {

    //creacion del objeto JSON - se deben generar lo getter and setter
    private String A_Id; // *
    private String B_Categoria; // *
    private String C_Usuario; //
    private String D_Fecha_Registro; // *
    private String E_Fecha_Empaque; //
    private String F_Zona; // *
    private String G_Rancho; //
    private String H_Variedad_Seleccion; // *
    private String I_Clon; // *
    private String J_Producto_Plantado; // *
    private String K_Cavidad_Trasplantada; // *
    private String L_Total_Planta_Plantada; // *
    private String M_Destino; // *
    private String N_Nota; // *
    private String O_; // *

    public void bkempaque(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro,
                          String e_Fecha_Empaque, String f_Zona, String g_Rancho, String h_Variedad_Seleccion,
                          String i_Clon, String j_Producto_Plantado, String k_Cavidad_Trasplantada,
                          String l_Total_Planta_Plantada, String m_Destino, String n_Nota){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Empaque = e_Fecha_Empaque;
        this.F_Zona = f_Zona;
        this.G_Rancho = g_Rancho;
        this.H_Variedad_Seleccion = h_Variedad_Seleccion;
        this.I_Clon = i_Clon;
        this.J_Producto_Plantado = j_Producto_Plantado;
        this.K_Cavidad_Trasplantada = k_Cavidad_Trasplantada;
        this.L_Total_Planta_Plantada = l_Total_Planta_Plantada;
        this.M_Destino = m_Destino;
        this.N_Nota = n_Nota;
    }

    public String getA_Id() {
        return A_Id;
    }

    public void setA_Id(String a_Id) {
        A_Id = a_Id;
    }

    public String getB_Categoria() {
        return B_Categoria;
    }

    public void setB_Categoria(String b_Categoria) {
        B_Categoria = b_Categoria;
    }

    public String getC_Usuario() {
        return C_Usuario;
    }

    public void setC_Usuario(String c_Usuario) {
        C_Usuario = c_Usuario;
    }

    public String getD_Fecha_Registro() {
        return D_Fecha_Registro;
    }

    public void setD_Fecha_Registro(String d_Fecha_Registro) {
        D_Fecha_Registro = d_Fecha_Registro;
    }

    public String getE_Fecha_Empaque() {
        return E_Fecha_Empaque;
    }

    public void setE_Fecha_Empaque(String e_Fecha_Empaque) {
        E_Fecha_Empaque = e_Fecha_Empaque;
    }

    public String getF_Zona() {
        return F_Zona;
    }

    public void setF_Zona(String f_Zona) {
        F_Zona = f_Zona;
    }

    public String getG_Rancho() {
        return G_Rancho;
    }

    public void setG_Rancho(String g_Rancho) {
        G_Rancho = g_Rancho;
    }

    public String getH_Variedad_Seleccion() {
        return H_Variedad_Seleccion;
    }

    public void setH_Variedad_Seleccion(String h_Variedad_Seleccion) {
        H_Variedad_Seleccion = h_Variedad_Seleccion;
    }

    public String getI_Clon() {
        return I_Clon;
    }

    public void setI_Clon(String i_Clon) {
        I_Clon = i_Clon;
    }

    public String getJ_Producto_Plantado() {
        return J_Producto_Plantado;
    }

    public void setJ_Producto_Plantado(String j_Producto_Plantado) {
        J_Producto_Plantado = j_Producto_Plantado;
    }

    public String getK_Cavidad_Trasplantada() {
        return K_Cavidad_Trasplantada;
    }

    public void setK_Cavidad_Trasplantada(String k_Cavidad_Trasplantada) {
        K_Cavidad_Trasplantada = k_Cavidad_Trasplantada;
    }

    public String getL_Total_Planta_Plantada() {
        return L_Total_Planta_Plantada;
    }

    public void setL_Total_Planta_Plantada(String l_Total_Planta_Plantada) {
        L_Total_Planta_Plantada = l_Total_Planta_Plantada;
    }

    public String getM_Destino() {
        return M_Destino;
    }

    public void setM_Destino(String m_Destino) {
        M_Destino = m_Destino;
    }

    public String getN_Nota() {
        return N_Nota;
    }

    public void setN_Nota(String n_Nota) {
        N_Nota = n_Nota;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((BKEmpaque)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Empaque,
                F_Zona, G_Rancho, H_Variedad_Seleccion, I_Clon, J_Producto_Plantado,
                K_Cavidad_Trasplantada, L_Total_Planta_Plantada, M_Destino, N_Nota, O_);
    }
}
