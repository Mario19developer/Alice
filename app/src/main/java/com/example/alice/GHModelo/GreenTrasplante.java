package com.example.alice.GHModelo;

import java.util.Objects;

public class GreenTrasplante {

    //Se genera la BD despues crea los getter and setter
    private String A_Id;
    private String B_Categoria; //Trasplante
    private String C_Usuario; // *
    private String D_Fecha_Registro; //
    private String E_Fecha_Trasplante; // *
    private String F_Rancho_Plantacion;
    private String G_Cultivo;
    private String H_Proyecto;
    private String I_Lote_Origen;
    private String J_Variedad_Seleccion; //
    private String K_Sector; // Nave
    private String L_Tunel; // Aguilon
    private String M_Lado; // Lado
    private String N_Cama; // Cama
    private String O_Lote_Trasplantado; //
    private String P_Calidad_Material; //
    private String Q_Cavidad_Trasplantada; //
    private String R_Charolas_completas_plantadas; //
    private String S_Plantas_por_charola_completa; //
    private String T_Plantas_Sueltas; //
    private String U_Total_planta_plantada; //
    private String V_Semana_Trasplante; //
    private String W_Semana_Entrega; //
    private String X_Nota; //

    public void greentrasplante(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro, String e_Fecha_Trasplante, String f_Rancho_Plantacion, String g_Cultivo, String h_Proyecto,
                                String i_Lote_Origen, String j_Variedad_Seleccion, String k_Sector, String l_Tunel, String m_Lado, String n_Cama, String o_Lote_Trasplantado, String p_Calidad_material,
                                String q_Cavidad_Trasplantada, String r_Charolas_completas_plantadas, String s_Plantas_por_charola_completa, String t_Plantas_Suelta,
                                String u_Total_planta_plantada, String v_Semana_Trasplante, String w_Semana_Entrega, String x_Nota){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Trasplante = e_Fecha_Trasplante;
        this.F_Rancho_Plantacion = f_Rancho_Plantacion;
        this.G_Cultivo = g_Cultivo;
        this.H_Proyecto = h_Proyecto;
        this.I_Lote_Origen = i_Lote_Origen;
        this.J_Variedad_Seleccion = j_Variedad_Seleccion;
        this.K_Sector = k_Sector;
        this.L_Tunel = l_Tunel;
        this.M_Lado = m_Lado;
        this.N_Cama = n_Cama;
        this.O_Lote_Trasplantado = o_Lote_Trasplantado;
        this.P_Calidad_Material = p_Calidad_material;
        this.Q_Cavidad_Trasplantada = q_Cavidad_Trasplantada;
        this.R_Charolas_completas_plantadas = r_Charolas_completas_plantadas;
        this.S_Plantas_por_charola_completa = s_Plantas_por_charola_completa;
        this.T_Plantas_Sueltas = t_Plantas_Suelta;
        this.U_Total_planta_plantada = u_Total_planta_plantada;
        this.V_Semana_Trasplante = v_Semana_Trasplante;
        this.W_Semana_Entrega = w_Semana_Entrega;
        this.X_Nota = x_Nota;
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

    public String getF_Rancho_Plantacion() {
        return F_Rancho_Plantacion;
    }

    public void setF_Rancho_Plantacion(String f_Rancho_Plantacion) {
        F_Rancho_Plantacion = f_Rancho_Plantacion;
    }

    public String getG_Cultivo() {
        return G_Cultivo;
    }

    public void setG_Cultivo(String g_Cultivo) {
        G_Cultivo = g_Cultivo;
    }

    public String getH_Proyecto() {
        return H_Proyecto;
    }

    public void setH_Proyecto(String h_Proyecto) {
        H_Proyecto = h_Proyecto;
    }

    public String getI_Lote_Origen() {
        return I_Lote_Origen;
    }

    public void setI_Lote_Origen(String i_Lote_Origen) {
        I_Lote_Origen = i_Lote_Origen;
    }

    public String getJ_Variedad_Seleccion() {
        return J_Variedad_Seleccion;
    }

    public void setJ_Variedad_Seleccion(String j_Variedad_Seleccion) {
        J_Variedad_Seleccion = j_Variedad_Seleccion;
    }

    public String getK_Sector() {
        return K_Sector;
    }

    public void setK_Sector(String k_Sector) {
        K_Sector = k_Sector;
    }

    public String getL_Tunel() {
        return L_Tunel;
    }

    public void setL_Tunel(String l_Tunel) {
        L_Tunel = l_Tunel;
    }

    public String getM_Lado() {
        return M_Lado;
    }

    public void setM_Lado(String m_Lado) {
        M_Lado = m_Lado;
    }

    public String getN_Cama() {
        return N_Cama;
    }

    public void setN_Cama(String n_Cama) {
        N_Cama = n_Cama;
    }

    public String getO_Lote_Trasplantado() {
        return O_Lote_Trasplantado;
    }

    public void setO_Lote_Trasplantado(String o_Lote_Trasplantado) {
        O_Lote_Trasplantado = o_Lote_Trasplantado;
    }

    public String getP_Calidad_Material() {
        return P_Calidad_Material;
    }

    public void setP_Calidad_Material(String p_Calidad_Material) {
        P_Calidad_Material = p_Calidad_Material;
    }

    public String getQ_Cavidad_Trasplantada() {
        return Q_Cavidad_Trasplantada;
    }

    public void setQ_Cavidad_Trasplantada(String q_Cavidad_Plantada) {
        Q_Cavidad_Trasplantada = q_Cavidad_Plantada;
    }

    public String getR_Charolas_completas_plantadas() {
        return R_Charolas_completas_plantadas;
    }

    public void setR_Charolas_completas_plantadas(String r_Charolas_completas_plantadas) {
        R_Charolas_completas_plantadas = r_Charolas_completas_plantadas;
    }

    public String getS_Plantas_por_charola_completa() {
        return S_Plantas_por_charola_completa;
    }

    public void setS_Plantas_por_charola_completa(String s_Plantas_por_charola_completa) {
        S_Plantas_por_charola_completa = s_Plantas_por_charola_completa;
    }

    public String getT_Plantas_Sueltas() {
        return T_Plantas_Sueltas;
    }

    public void setT_Plantas_Sueltas(String t_Plantas_Sueltas) {
        T_Plantas_Sueltas = t_Plantas_Sueltas;
    }

    public String getU_Total_planta_plantada() {
        return U_Total_planta_plantada;
    }

    public void setU_Total_planta_plantada(String u_Total_planta_plantada) {
        U_Total_planta_plantada = u_Total_planta_plantada;
    }

    public String getV_Semana_Trasplante() {
        return V_Semana_Trasplante;
    }

    public void setV_Semana_Trasplante(String v_Semana_Trasplante) {
        V_Semana_Trasplante = v_Semana_Trasplante;
    }

    public String getW_Semana_Entregae() {
        return W_Semana_Entrega;
    }

    public void setW_Semana_Entregae(String w_Semana_Entregae) {
        W_Semana_Entrega = w_Semana_Entregae;
    }

    public String getX_Nota() {
        return X_Nota;
    }

    public void setX_Nota(String x_Nota) {
        X_Nota = x_Nota;
    }

    @Override
    public boolean equals(Object obj) {
        return  A_Id.equals(((GreenTrasplante)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Trasplante, F_Rancho_Plantacion, G_Cultivo, H_Proyecto, I_Lote_Origen, J_Variedad_Seleccion,
                K_Sector, L_Tunel, M_Lado, N_Cama, O_Lote_Trasplantado, P_Calidad_Material, Q_Cavidad_Trasplantada, R_Charolas_completas_plantadas, S_Plantas_por_charola_completa,
                T_Plantas_Sueltas, U_Total_planta_plantada, V_Semana_Trasplante, W_Semana_Entrega, X_Nota);
    }
}
