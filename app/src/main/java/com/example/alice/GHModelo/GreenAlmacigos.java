package com.example.alice.GHModelo;

import java.util.Objects;

public class GreenAlmacigos {

    //creacion del objeto JSON - se deben generar lo getter and setter
    private String A_Id; // *
    private String B_Categoria; //
    private String C_Usuario; // *
    private String D_Fecha_Registro; //
    private String E_Fecha_Plantacion; // *
    private String F_Zona; //
    private String G_Rancho_Plantacion; // *
    private String H_Cultivo; //
    private String I_Codigo_de_Origen; //
    private String J_Sector; // *
    private String K_Tunel; // *
    private String L_Lado; // *
    private String M_Cama; // *
    private String N_Ancho_Cama; //
    private String O_Largo_Cama; //
    private String P_Variedad_Seleccion; //
    private String Q_Clon; //
    private String R_Material_Establecido; //
    private String S_Presentacion_Material; //
    private String T_Capacidad_de_Maceta; //
    private String U_Catidad_Plantada; //
    private String V_Lote_Asignado; //
    private String W_Nota_Plantacion;
    private String X_Proyecto;//

    public void greenalmacigos(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro, String e_Fecha_Plantacion, String f_Zona, String g_Rancho_Plantacion,
                               String h_Cultivo, String i_Codigo_de_Origen, String j_Sector, String k_Tunel, String l_Lado, String m_Cama, String n_Ancho_Cama, String o_Largo_Cama,
                               String p_Variedad_Seleccion, String q_Clon, String r_Material_Establecido, String s_Presentacion_Material, String t_Capacidad_de_Maceta, String u_Catidad_Plantada,
                               String v_Lote_Asignado,String w_Nota_Plantacion, String x_Proyecto){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Plantacion = e_Fecha_Plantacion;
        this.F_Zona = f_Zona;
        this.G_Rancho_Plantacion = g_Rancho_Plantacion;
        this.H_Cultivo = h_Cultivo;
        this.I_Codigo_de_Origen = i_Codigo_de_Origen;
        this.J_Sector = j_Sector;
        this.K_Tunel = k_Tunel;
        this.L_Lado = l_Lado;
        this.M_Cama = m_Cama;
        this.N_Ancho_Cama = n_Ancho_Cama;
        this.O_Largo_Cama = o_Largo_Cama;
        this.P_Variedad_Seleccion = p_Variedad_Seleccion;
        this.Q_Clon = q_Clon;
        this.R_Material_Establecido = r_Material_Establecido;
        this.S_Presentacion_Material = s_Presentacion_Material;
        this.T_Capacidad_de_Maceta = t_Capacidad_de_Maceta;
        this.U_Catidad_Plantada = u_Catidad_Plantada;
        this.V_Lote_Asignado = v_Lote_Asignado;
        this.W_Nota_Plantacion = w_Nota_Plantacion;
        this.X_Proyecto = x_Proyecto;

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

    public String getE_Fecha_Plantacion() {
        return E_Fecha_Plantacion;
    }

    public void setE_Fecha_Plantacion(String e_Fecha_Plantacion) {
        E_Fecha_Plantacion = e_Fecha_Plantacion;
    }

    public String getF_Zona() {
        return F_Zona;
    }

    public void setF_Zona(String f_Zona) {
        F_Zona = f_Zona;
    }

    public String getG_Rancho_Plantacion() {
        return G_Rancho_Plantacion;
    }

    public void setG_Rancho_Plantacion(String g_Rancho_Plantacion) {
        G_Rancho_Plantacion = g_Rancho_Plantacion;
    }

    public String getH_Cultivo() {
        return H_Cultivo;
    }

    public void setH_Cultivo(String h_Cultivo) {
        H_Cultivo = h_Cultivo;
    }

    public String getI_Codigo_de_Origen() {
        return I_Codigo_de_Origen;
    }

    public void setI_Codigo_de_Origen(String i_Codigo_de_Origen) {
        I_Codigo_de_Origen = i_Codigo_de_Origen;
    }

    public String getJ_Sector() {
        return J_Sector;
    }

    public void setJ_Sector(String j_Sector) {
        J_Sector = j_Sector;
    }

    public String getK_Tunel() {
        return K_Tunel;
    }

    public void setK_Tunel(String k_Tunel) {
        K_Tunel = k_Tunel;
    }

    public String getL_Lado() {
        return L_Lado;
    }

    public void setL_Lado(String l_Lado) {
        L_Lado = l_Lado;
    }

    public String getM_Cama() {
        return M_Cama;
    }

    public void setM_Cama(String m_Cama) {
        M_Cama = m_Cama;
    }

    public String getN_Ancho_Cama() {
        return N_Ancho_Cama;
    }

    public void setN_Ancho_Cama(String n_Ancho_Cama) {
        N_Ancho_Cama = n_Ancho_Cama;
    }

    public String getO_Largo_Cama() {
        return O_Largo_Cama;
    }

    public void setO_Largo_Cama(String o_Largo_Cama) {
        O_Largo_Cama = o_Largo_Cama;
    }

    public String getP_Variedad_Seleccion() {
        return P_Variedad_Seleccion;
    }

    public void setP_Variedad_Seleccion(String p_Variedad_Seleccion) {
        P_Variedad_Seleccion = p_Variedad_Seleccion;
    }

    public String getQ_Clon() {
        return Q_Clon;
    }

    public void setQ_Clon(String q_Clon) {
        Q_Clon = q_Clon;
    }

    public String getR_Material_Establecido() {
        return R_Material_Establecido;
    }

    public void setR_Material_Establecido(String r_Material_Establecido) {
        R_Material_Establecido = r_Material_Establecido;
    }

    public String getS_Presentacion_Material() {
        return S_Presentacion_Material;
    }

    public void setS_Presentacion_Material(String s_Presentacion_Material) {
        S_Presentacion_Material = s_Presentacion_Material;
    }

    public String getT_Capacidad_de_Maceta() {
        return T_Capacidad_de_Maceta;
    }

    public void setT_Capacidad_de_Maceta(String t_Capacidad_de_Maceta) {
        T_Capacidad_de_Maceta = t_Capacidad_de_Maceta;
    }

    public String getU_Catidad_Plantada() {
        return U_Catidad_Plantada;
    }

    public void setU_Catidad_Plantada(String u_Catidad_Plantada) {
        U_Catidad_Plantada = u_Catidad_Plantada;
    }

    public String getV_Lote_Asignado() {
        return V_Lote_Asignado;
    }

    public void setV_Lote_Asignado(String v_Lote_Asignado) {
        V_Lote_Asignado = v_Lote_Asignado;
    }

    public String getW_Nota_Plantacion() {
        return W_Nota_Plantacion;
    }

    public void setW_Nota_Plantacion(String w_Nota_Plantacion) {
        W_Nota_Plantacion = w_Nota_Plantacion;
    }

    public String getX_Proyecto() {
        return X_Proyecto;
    }

    public void setX_Proyecto(String x_Proyecto) {
        X_Proyecto = x_Proyecto;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((GreenAlmacigos)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Plantacion, F_Zona, G_Rancho_Plantacion, H_Cultivo, I_Codigo_de_Origen, J_Sector, K_Tunel,
                L_Lado, M_Cama, N_Ancho_Cama, O_Largo_Cama, P_Variedad_Seleccion, Q_Clon, R_Material_Establecido, S_Presentacion_Material, T_Capacidad_de_Maceta,
                U_Catidad_Plantada, V_Lote_Asignado, W_Nota_Plantacion, X_Proyecto);
    }
}
