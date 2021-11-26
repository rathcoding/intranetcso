-- Cadastro do login do Admin:
insert into t_cso_psi values ("02925522971", "RAFAEL RATH", "e8d95a51f3af4a3b134bf6bb680a213a", "DIFRON", 1);
insert into t_cso_psi values ("02286340919", "JULIANA BELINCANTA", "5c718ebf3bd52194054375cd6a0042c1", "GEPES", 2);
insert into t_cso_psi values ("88899454949", "MONICA HENRIQUE DA SILVA DE S THIAGO", "5c718ebf3bd52194054375cd6a0042c1", "GEPES", 2);
insert into t_cso_psi values ("00507766903", "MICHELLE VECCHI", "5c718ebf3bd52194054375cd6a0042c1", "DPGF", 3);
insert into t_cso_psi values ("03590408618", "ISIS MARIA IGNACIO RODRIGUES", "5c718ebf3bd52194054375cd6a0042c1", "DPGF", 3);
insert into t_cso_psi values ("06134757985", "ANA PAULA FRASSON DOS SANTOS BORGES", "5c718ebf3bd52194054375cd6a0042c1", "DPOI", 3);
insert into t_cso_psi values ("04880146978", "KATIA DO VALE PEREIRA FLORES DA SILVA", "5c718ebf3bd52194054375cd6a0042c1", "DPOL", 3);
insert into t_cso_psi values ("88284484900", "MARCIA MARIA DOS SANTOS", "5c718ebf3bd52194054375cd6a0042c1", "DPOL", 3);
insert into t_cso_psi values ("68607490915", "SILVIA PERES MORAES SILVA", "5c718ebf3bd52194054375cd6a0042c1", "DPOL", 3);
insert into t_cso_psi values ("05259514904", "VANESSA LANER GARCIA COSTA", "5c718ebf3bd52194054375cd6a0042c1", "GEPES", 3);
insert into t_cso_psi values ("05500562975", "ANA SILVIA SERRANO GHISI", "5c718ebf3bd52194054375cd6a0042c1", "GEPES", 0);

-- Cadastro de servidores:
insert into t_cso_servidor values ("12345678910", "FULANO DE TAL", "AGENTE DE POLICIA CIVIL CLASSE V", "1987-09-17", 		"1234567-8-09", "2009-11-04", "2009-11-04", "detal@pc.sc.gov.br", "(49) 2049-9999", "(49) 99999-1234", "DGPC/DIFRON/DRP12/DIC");
insert into t_cso_servidor values ("10987654321", "BELTRANO DA SILVA", "ESCRIVAO DE POLICIA CIVIL CLASSE VI", "1984-08-16", "9876543-2-01", "2010-06-07", "2010-06-07", "beltrano@pc.sc.gov.br", "(49) 2049-8888", "(49) 99999-4321", "DGPC/DPGF/DRP01/1DPSJ");
insert into t_cso_servidor values ("11122233344", "CICLANO LOPES", "ESCRIVAO DE POLICIA CIVIL CLASSE IV", "1988-03-12", "0200342-2-01", "2016-10-01", "2016-10-01", "ciclano@pc.sc.gov.br", "(49) 2049-8888", "(49) 99999-4321", "DGPC/DPOI/DRP08/DPCAMI");
insert into t_cso_servidor values ("33322211100", "SIGMUND FREUD", "PSICOLOGO POLICIAL CIVIL CLASSE VIII", "1856-05-06", "0153200-1-01", "1999-01-01", "1999-01-01", "freud@pc.sc.gov.br", "(49) 2049-8888", "(49) 99999-4321", "DGPC/DPOL/DRP07/DPCO");
insert into t_cso_servidor values ("99988877766", "AARON T. BECK", "PSICOLOGO POLICIAL CIVIL CLASSE VIII", "1921-07-18", "0300200-1-01", "2000-07-01", "2000-07-01", "beck@pc.sc.gov.br", "(49) 2049-8888", "(49) 99999-4321", "DGPC/DIFRON/DRP13/DPCAMI");


-- Cadastro de tipos de casos:
insert into t_cso_tipo_caso values ("LTS");
insert into t_cso_tipo_caso values ("LTF");
insert into t_cso_tipo_caso values ("LTS CEAT");
insert into t_cso_tipo_caso values ("Avaliação Funcional");
insert into t_cso_tipo_caso values ("Psicoterapia Breve");
insert into t_cso_tipo_caso values ("Intervenção em Incidente Crítico");

-- Cadastro de tipos de intervenção:
insert into t_cso_tipo_intervencao values ("Atendimento individual");
insert into t_cso_tipo_intervencao values ("Avaliação para Porte de Arma de Fogo");
insert into t_cso_tipo_intervencao values ("Contato com chefia");
insert into t_cso_tipo_intervencao values ("Contato eletrônico");
insert into t_cso_tipo_intervencao values ("Elaboração de documento");
insert into t_cso_tipo_intervencao values ("Planejamento de intervenção");
insert into t_cso_tipo_intervencao values ("Correção de testes");

-- Cadastro de códigos CID:
insert into t_cso_cid values ("F00 - Demência na Doença de Alzheimer");
insert into t_cso_cid values ("F01 - Demência Vascular");
insert into t_cso_cid values ("F02 - Demência em Outras Doenças Classificadas em Outra Parte");
insert into t_cso_cid values ("F03 - Demência Não Especificada");
insert into t_cso_cid values ("F04 - Síndrome Amnésica Orgânica Não Induzida Pelo Álcool ou Por Outras Substâncias Psicoativas");
insert into t_cso_cid values ("F05 - Delirium Não Induzido Pelo Álcool ou Por Outras Substâncias Psicoativas");
insert into t_cso_cid values ("F06 - Outros Transtornos Mentais Devidos a Lesão e Disfunção Cerebral e a Doença Física");
insert into t_cso_cid values ("F07 - Transtornos de Personalidade e do Comportamento Devidos a Doença, a Lesão e a Disfunção Cerebral");
insert into t_cso_cid values ("F09 - Transtorno Mental Orgânico ou Sintomático Não Especificado");
insert into t_cso_cid values ("F10 - Transtornos Mentais e Comportamentais Devidos ao Uso de Álcool");
insert into t_cso_cid values ("F11 - Transtornos Mentais e Comportamentais Devidos ao Uso de Opiáceos");
insert into t_cso_cid values ("F12 - Transtornos Mentais e Comportamentais Devidos ao Uso de Canabinóides");
insert into t_cso_cid values ("F13 - Transtornos Mentais e Comportamentais Devidos ao Uso de Sedativos e Hipnóticos");
insert into t_cso_cid values ("F14 - Transtornos Mentais e Comportamentais Devidos ao Uso da Cocaína");
insert into t_cso_cid values ("F15 - Transtornos Mentais e Comportamentais Devidos ao Uso de Outros Estimulantes, Inclusive a Cafeína");
insert into t_cso_cid values ("F16 - Transtornos Mentais e Comportamentais Devidos ao Uso de Alucinógenos");
insert into t_cso_cid values ("F17 - Transtornos Mentais e Comportamentais Devidos ao Uso de Fumo");
insert into t_cso_cid values ("F18 - Transtornos Mentais e Comportamentais Devidos ao Uso de Solventes Voláteis");
insert into t_cso_cid values ("F19 - Transtornos Mentais e Comportamentais Devidos ao Uso de Múltiplas Drogas e ao Uso de Outras Substâncias Psicoativas");
insert into t_cso_cid values ("F20 - Esquizofrenia");
insert into t_cso_cid values ("F21 - Transtorno Esquizotípico");
insert into t_cso_cid values ("F22 - Transtornos Delirantes Persistentes");
insert into t_cso_cid values ("F23 - Transtornos Psicóticos Agudos e Transitórios");
insert into t_cso_cid values ("F24 - Transtorno Delirante Induzido");
insert into t_cso_cid values ("F25 - Transtornos Esquizoafetivos");
insert into t_cso_cid values ("F28 - Outros Transtornos Psicóticos Não-orgânicos");
insert into t_cso_cid values ("F29 - Psicose Não-orgânica Não Especificada");
insert into t_cso_cid values ("F30 - Episódio Maníaco");
insert into t_cso_cid values ("F31 - Transtorno Afetivo Bipolar");
insert into t_cso_cid values ("F32 - Episódios Depressivos");
insert into t_cso_cid values ("F33 - Transtorno Depressivo Recorrente");
insert into t_cso_cid values ("F34 - Transtornos de Humor (afetivos) Persistentes");
