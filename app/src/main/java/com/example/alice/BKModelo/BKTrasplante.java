package com.example.alice.BKModelo;

import java.util.Objects;

public class BKTrasplante {

    //creacion del objeto JSON - se deben generar lo getter and setter
    private String A_Id; // *
    private String B_Categoria; //
    private String C_Usuario; //
    private String D_Fecha_Registro; // *
    private String E_Fecha_Trasplante; //
    private String F_Zona; //
    private String G_Rancho; //
    private String H_Cama; //
    private String I_Posicion; //
    private String J_Lado; //
    private String K_Variedad_Seleccion; //
    private String L_Clon; //
    private String M_Producto_Plantado; //
    private String N_Numero_de_Cosecha; //
    private String O_Cavidad_Brotes; //
    private String P_Cavidad_Trasplantada; //
    private String Q_QTY_Charolas_Completas_Plantadas; //
    private String R_QTY_Planta_por_charola_Completa; //
    private String S_QTY_Planta_por_charola_Suelta; //
    private String T_Total_Planta_Plantada; //
    private String U_Codigo_Almacigo; //
    private String V_Nota; //


    public void bktrasplante(String a_Id, String b_Categoria, String c_Usuario,
                             String d_Fecha_Registro, String e_Fecha_Trasplante, String f_Zona,
                             String g_Rancho, String h_Cama, String i_Posicion, String j_Lado,
                             String k_Variedad_Seleccion, String l_Clon, String m_Producto_Plantado,
                             String n_Numero_de_Cosecha, String O_Cavidad_Brotes,
                             String P_Cavidad_Trasplantada, String q_QTY_Charolas_Completas_Plantadas,
                             String r_QTY_Planta_por_charola_Completa, String s_QTY_Planta_por_charola_Suelta,
                             String t_Total_Planta_Plantada, String U_Codigo_Almacigo, String V_Nota){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Trasplante = e_Fecha_Trasplante;
        this.F_Zona = f_Zona;
        this.G_Rancho = g_Rancho;
        this.H_Cama = h_Cama;
        this.I_Posicion = i_Posicion;
        this.J_Lado = j_Lado;
        this.K_Variedad_Seleccion = k_Variedad_Seleccion;
        this.L_Clon = l_Clon;
        this.M_Producto_Plantado = m_Producto_Plantado;
        this.N_Numero_de_Cosecha = n_Numero_de_Cosecha;
        this.O_Cavidad_Brotes = O_Cavidad_Brotes;
        this.P_Cavidad_Trasplantada = P_Cavidad_Trasplantada;
        this.Q_QTY_Charolas_Completas_Plantadas = q_QTY_Charolas_Completas_Plantadas;
        this.R_QTY_Planta_por_charola_Completa = r_QTY_Planta_por_charola_Completa;
        this.S_QTY_Planta_por_charola_Suelta = s_QTY_Planta_por_charola_Suelta;
        this.T_Total_Planta_Plantada = t_Total_Planta_Plantada;
        this.U_Codigo_Almacigo = U_Codigo_Almacigo;
        this.V_Nota = V_Nota;

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

    public String getE_Fecha_Trasplante() {
        return E_Fecha_Trasplante;
    }

    public void setE_Fecha_Trasplante(String e_Fecha_Trasplante) {
        E_Fecha_Trasplante = e_Fecha_Trasplante;
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

    public String getH_Cama() {
        return H_Cama;
    }

    public void setH_Cama(String h_Cama) {
        H_Cama = h_Cama;
    }

    public String getI_Posicion() {
        return I_Posicion;
    }

    public void setI_Posicion(String i_Posicion) {
        I_Posicion = i_Posicion;
    }

    public String getJ_Lado() {
        return J_Lado;
    }

    public void setJ_Lado(String j_Lado) {
        J_Lado = j_Lado;
    }

    public String getK_Variedad_Seleccion() {
        return K_Variedad_Seleccion;
    }

    public void setK_Variedad_Seleccion(String k_Variedad_Seleccion) {
        K_Variedad_Seleccion = k_Variedad_Seleccion;
    }

    public String getL_Clon() {
        return L_Clon;
    }

    public void setL_Clon(String l_Clon) {
        L_Clon = l_Clon;
    }

    public String getM_Producto_Plantado() {
        return M_Producto_Plantado;
    }

    public void setM_Producto_Plantado(String m_Producto_Plantado) {
        M_Producto_Plantado = m_Producto_Plantado;
    }

    public String getN_Numero_de_Cosecha() {
        return N_Numero_de_Cosecha;
    }

    public void setN_Numero_de_Cosecha(String n_Numero_de_Cosecha) {
        N_Numero_de_Cosecha = n_Numero_de_Cosecha;
    }

    public String getO_Cavidad_Brotes() {
        return O_Cavidad_Brotes;
    }

    public void setO_Cavidad_Brotes(String o_Cavidad_Brotes) {
        O_Cavidad_Brotes = o_Cavidad_Brotes;
    }

    public String getP_Cavidad_Trasplantada() {
        return P_Cavidad_Trasplantada;
    }

    public void setP_Cavidad_Trasplantada(String p_Cavidad_Trasplantada) {
        P_Cavidad_Trasplantada = p_Cavidad_Trasplantada;
    }

    public String getQ_QTY_Charolas_Completas_Plantadas() {
        return Q_QTY_Charolas_Completas_Plantadas;
    }

    public void setQ_QTY_Charolas_Completas_Plantadas(String q_QTY_Charolas_Completas_Plantadas) {
        Q_QTY_Charolas_Completas_Plantadas = q_QTY_Charolas_Completas_Plantadas;
    }

    public String getR_QTY_Planta_por_charola_Completa() {
        return R_QTY_Planta_por_charola_Completa;
    }

    public void setR_QTY_Planta_por_charola_Completa(String r_QTY_Planta_por_charola_Completa) {
        R_QTY_Planta_por_charola_Completa = r_QTY_Planta_por_charola_Completa;
    }

    public String getS_QTY_Planta_por_charola_Suelta() {
        return S_QTY_Planta_por_charola_Suelta;
    }

    public void setS_QTY_Planta_por_charola_Suelta(String s_QTY_Planta_por_charola_Suelta) {
        S_QTY_Planta_por_charola_Suelta = s_QTY_Planta_por_charola_Suelta;
    }

    public String getT_Total_Planta_Plantada() {
        return T_Total_Planta_Plantada;
    }

    public void setT_Total_Planta_Plantada(String t_Total_Planta_Plantada) {
        T_Total_Planta_Plantada = t_Total_Planta_Plantada;
    }

    public String getU_Codigo_Almacigo() {
        return U_Codigo_Almacigo;
    }

    public void setU_Codigo_Almacigo(String u_Codigo_Almacigo) {
        U_Codigo_Almacigo = u_Codigo_Almacigo;
    }

    public String getV_Nota() {
        return V_Nota;
    }

    public void setV_Nota(String v_Nota) {
        V_Nota = v_Nota;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((BKTrasplante)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro,
                E_Fecha_Trasplante, F_Zona, G_Rancho, H_Cama, I_Posicion, J_Lado,
                K_Variedad_Seleccion, L_Clon, M_Producto_Plantado, N_Numero_de_Cosecha,
                O_Cavidad_Brotes, P_Cavidad_Trasplantada,
                Q_QTY_Charolas_Completas_Plantadas, R_QTY_Planta_por_charola_Completa,
                S_QTY_Planta_por_charola_Suelta, T_Total_Planta_Plantada, U_Codigo_Almacigo, V_Nota);
    }
}
