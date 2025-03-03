<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm">
                    <fo:region-body margin="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="24pt" font-weight="bold" margin-bottom="20pt">List of Players</fo:block>
                    <fo:block font-size="18pt" margin-bottom="12pt">Player Details:</fo:block>

                    <fo:table border="1pt solid black" width="100%" table-layout="fixed">
                        <fo:table-column column-width="40%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="10%"/>
                        <fo:table-column column-width="10%"/>

                        <fo:table-header>
                            <fo:table-row background-color="#d3d3d3">
                                <fo:table-cell border="1pt solid black" padding="4pt">
                                    <fo:block font-weight="bold">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="4pt">
                                    <fo:block font-weight="bold">Role</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="4pt">
                                    <fo:block font-weight="bold">Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="4pt">
                                    <fo:block font-weight="bold">Team</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black" padding="4pt">
                                    <fo:block font-weight="bold">Price (Cr.)</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <fo:table-body>
                            <xsl:for-each select="players/player">
                                <fo:table-row>
                                    <fo:table-cell border="1pt solid black" padding="4pt">
                                        <fo:block><xsl:value-of select="name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="4pt">
                                        <fo:block><xsl:value-of select="role"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="4pt">
                                        <fo:block><xsl:value-of select="country"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="4pt">
                                        <fo:block><xsl:value-of select="team"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black" padding="4pt">
                                        <fo:block><xsl:value-of select="price"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
