package com.example.alice.BKModelo;

import java.util.Objects;

public class BKMortandad {

    //creacion del objeto JSON - se deben generar lo getter and setter
    private String A_Id;
    private String B_Categoria;
    private String C_Usuario;
    private String D_Fecha_Registro;
    private String E_Fecha_Muestreo;
    private String F_Etapa_Conteo;
    private String G_Zona;
    private String H_Rancho_Plantacion;
    private String I_Cama;
    private String J_Posicion;
    private String K_Lado;
    private String L_Variedad_Seleccion;
    private String M_Clon;
    private String N_Producto_Plantado;
    private String O_Numero_de_Cosecha;
    private String P_Cavidad_Plantada;
    private String Q_Cantidad_Planta_Muerta;
    private String R_Nota;
    private String S_;


    public void bkmortandad(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro,
                            String e_Fecha_Muestreo, String f_Etapa_Conteo, String g_Zona, String h_Rancho_Plantacion,
                            String i_Cama, String j_Posicion, String k_Lado, String l_Variedad_Seleccion,
                            String m_Clon, String n_Producto_Plantado, String o_Numero_de_Cosecha,
                            String p_Cavidad_Plantada, String q_Cantidad_Planta_Muerta, String r_Nota){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Muestreo = e_Fecha_Muestreo;
        this.F_Etapa_Conteo = f_Etapa_Conteo;
        this.G_Zona = g_Zona;
        this.H_Rancho_Plantacion = h_Rancho_Plantacion;
        this.I_Cama = i_Cama;
        this.J_Posicion = j_Posicion;
        this.K_Lado = k_Lado;
        this.L_Variedad_Seleccion = l_Variedad_Seleccion;
        this.M_Clon= m_Clon;
        this.N_Producto_Plantado = n_Producto_Plantado;
        this.O_Numero_de_Cosecha = o_Numero_de_Cosecha;
        this.P_Cavidad_Plantada = p_Cavidad_Plantada;
        this.Q_Cantidad_Planta_Muerta = q_Cantidad_Planta_Muerta;
        this.R_Nota = r_Nota;
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

    public String getE_Fecha_Muestreo() {
        return E_Fecha_Muestreo;
    }

    public void setE_Fecha_Muestreo(String e_Fecha_Muestreo) {
        E_Fecha_Muestreo = e_Fecha_Muestreo;
    }

    public String getF_Etapa_Conteo() {
        return F_Etapa_Conteo;
    }

    public void setF_Etapa_Conteo(String f_Etapa_Conteo) {
        F_Etapa_Conteo = f_Etapa_Conteo;
    }

    public String getG_Zona() {
        return G_Zona;
    }

    public void setG_Zona(String g_Zona) {
        G_Zona = g_Zona;
    }

    public String getH_Rancho_Plantacion() {
        return H_Rancho_Plantacion;
    }

    public void setH_Rancho_Plantacion(String h_Rancho_Plantacion) {
        H_Rancho_Plantacion = h_Rancho_Plantacion;
    }

    public String getI_Cama() {
        return I_Cama;
    }

    public void setI_Cama(String i_Cama) {
        I_Cama = i_Cama;
    }

    public String getJ_Posicion() {
        return J_Posicion;
    }

    public void setJ_Posicion(String j_Posicion) {
        J_Posicion = j_Posicion;
    }

    public String getK_Lado() {
        return K_Lado;
    }

    public void setK_Lado(String k_Lado) {
        K_Lado = k_Lado;
    }

    public String getL_Variedad_Seleccion() {
        return L_Variedad_Seleccion;
    }

    public void setL_Variedad_Seleccion(String l_Variedad_Seleccion) {
        L_Variedad_Seleccion = l_Variedad_Seleccion;
    }

    public String getM_Clon() {
        return M_Clon;
    }

    public void setM_Clon(String m_Clon) {
        M_Clon = m_Clon;
    }

    public String getN_Producto_Plantado() {
        return N_Producto_Plantado;
    }

    public void setN_Producto_Plantado(String n_Producto_Plantado) {
        N_Producto_Plantado = n_Producto_Plantado;
    }

    public String getO_Numero_de_Cosecha() {
        return O_Numero_de_Cosecha;
    }

    public void setO_Numero_de_Cosecha(String o_Numero_de_Cosecha) {
        O_Numero_de_Cosecha = o_Numero_de_Cosecha;
    }

    public String getP_Cavidad_Plantada() {
        return P_Cavidad_Plantada;
    }

    public void setP_Cavidad_Plantada(String p_Cavidad_Plantada) {
        P_Cavidad_Plantada = p_Cavidad_Plantada;
    }

    public String getQ_Cantidad_Planta_Muerta() {
        return Q_Cantidad_Planta_Muerta;
    }

    public void setQ_Cantidad_Planta_Muerta(String q_Cantidad_Planta_Muerta) {
        Q_Cantidad_Planta_Muerta = q_Cantidad_Planta_Muerta;
    }

    public String getR_Nota() {
        return R_Nota;
    }

    public void setR_Nota(String r_Nota) {
        R_Nota = r_Nota;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((BKMortandad)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Muestreo,
                F_Etapa_Conteo, G_Zona, H_Rancho_Plantacion, I_Cama, J_Posicion, K_Lado,
                L_Variedad_Seleccion, M_Clon, N_Producto_Plantado, O_Numero_de_Cosecha,
                P_Cavidad_Plantada, Q_Cantidad_Planta_Muerta, R_Nota, S_);
    }
}
