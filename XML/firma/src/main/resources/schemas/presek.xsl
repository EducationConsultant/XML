<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://codenotfound.com/types/presek" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.2in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="sans-serif" font-size="24px" font-weight="bold" padding="10px">
                        Zaglavlje
                    </fo:block>
                    <fo:block text-indent="10px">
                        Broj preseka: 
						<fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Broj_preseka"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Broj_racuna:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Broj_racuna"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Datum_naloga:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Datum_naloga"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Prethodno_stanje:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Prethodno_stanje"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Novo_stanje:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Novo_stanje"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Broj_promena_u_korist:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Broj_promena_u_korist"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Ukupno_u_korist:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Ukupno_u_korist"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Broj_promena_na_teret:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Broj_promena_na_teret"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-indent="10px">
                        Ukupno_na_teret:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="b:GetPresekResponse/b:Zaglavlje/b:Ukupno_na_teret"/>
                        </fo:inline>
                    </fo:block>
                    
                    <fo:block>
                        <fo:table font-size="8px" font-family="serif" margin="20px auto 20px auto" border="1px">
                            <fo:table-column column-width="9%"/>
                            <fo:table-column column-width="9%"/>
                            <fo:table-column column-width="9%"/>
                            <fo:table-column column-width="12%"/>
                            <fo:table-column column-width="12%"/>
                            <fo:table-column column-width="8%"/>
                            <fo:table-column column-width="9%"/>
                            <fo:table-column column-width="7%"/>
                            <fo:table-column column-width="6%"/>
                            <fo:table-column column-width="7%"/>
                            <fo:table-column column-width="13%"/>
                            <fo:table-body>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Duznik nalogodavac</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Primalac poverilac</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Svrha placanja</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Datum naloga</fo:block>
                                    </fo:table-cell> 
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Datum valute</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Racun duznika</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Model zaduzenja</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Poziv na broj odobrenja</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Iznos</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Smer</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#4caf50" font-family="sans-serif" color="white" padding="10px" font-weight="bold">
                                        <fo:block>Racun poverioca</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                    <xsl:for-each select="b:GetPresekResponse/b:Stavke/b:Stavka">
                                    <fo:table-row border="1px solid darkgrey">
                                        <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Duznik-nalogodavac" />
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Primalac-poverilac" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Svrha_placanja" />
                                            </fo:block>
                                        </fo:table-cell>
                                           <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Datum_naloga" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Datum_valute" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Racun_duznika" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Model_zaduzenja" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Poziv_na_broj_odobrenja" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Iznos" />
                                            </fo:block>
                                        </fo:table-cell>
                                         <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Smer" />
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell padding="10px">
                                            <fo:block>
                                                <xsl:value-of select="b:Racun_poverioca" />
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
