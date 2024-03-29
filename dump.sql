PGDMP         &                y            db_cooking_recipes    13.3    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    db_cooking_recipes    DATABASE     o   CREATE DATABASE db_cooking_recipes WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
 "   DROP DATABASE db_cooking_recipes;
                postgres    false            �            1259    24686    ing_rec    TABLE     H   CREATE TABLE public.ing_rec (
    ing_id integer,
    rec_id integer
);
    DROP TABLE public.ing_rec;
       public         heap    postgres    false            �            1259    24667    ingridients    TABLE     b   CREATE TABLE public.ingridients (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.ingridients;
       public         heap    postgres    false            �            1259    24665    ingridients_id_seq    SEQUENCE     �   ALTER TABLE public.ingridients ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ingridients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    24677    recipes    TABLE     ^   CREATE TABLE public.recipes (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.recipes;
       public         heap    postgres    false            �            1259    24675    recipes_id_seq    SEQUENCE     �   ALTER TABLE public.recipes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.recipes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    24657    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying NOT NULL,
    login character varying,
    password character varying
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    24655    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �          0    24686    ing_rec 
   TABLE DATA           1   COPY public.ing_rec (ing_id, rec_id) FROM stdin;
    public          postgres    false    206          �          0    24667    ingridients 
   TABLE DATA           /   COPY public.ingridients (id, name) FROM stdin;
    public          postgres    false    203   C       �          0    24677    recipes 
   TABLE DATA           +   COPY public.recipes (id, name) FROM stdin;
    public          postgres    false    205   �       �          0    24657    users 
   TABLE DATA           :   COPY public.users (id, name, login, password) FROM stdin;
    public          postgres    false    201   �       �           0    0    ingridients_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.ingridients_id_seq', 10, true);
          public          postgres    false    202            �           0    0    recipes_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.recipes_id_seq', 5, true);
          public          postgres    false    204            �           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 2, true);
          public          postgres    false    200            8           2606    24671    ingridients ingridients_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.ingridients
    ADD CONSTRAINT ingridients_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.ingridients DROP CONSTRAINT ingridients_pkey;
       public            postgres    false    203            :           2606    24684    recipes recipes_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.recipes
    ADD CONSTRAINT recipes_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.recipes DROP CONSTRAINT recipes_pkey;
       public            postgres    false    205            6           2606    24664    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    201            ;           1259    24694 
   fki_ing_id    INDEX     @   CREATE INDEX fki_ing_id ON public.ing_rec USING btree (ing_id);
    DROP INDEX public.fki_ing_id;
       public            postgres    false    206            <           2606    24689    ing_rec ing_id    FK CONSTRAINT     |   ALTER TABLE ONLY public.ing_rec
    ADD CONSTRAINT ing_id FOREIGN KEY (ing_id) REFERENCES public.ingridients(id) NOT VALID;
 8   ALTER TABLE ONLY public.ing_rec DROP CONSTRAINT ing_id;
       public          postgres    false    203    2872    206            =           2606    24695    ing_rec rec_id    FK CONSTRAINT     x   ALTER TABLE ONLY public.ing_rec
    ADD CONSTRAINT rec_id FOREIGN KEY (ing_id) REFERENCES public.recipes(id) NOT VALID;
 8   ALTER TABLE ONLY public.ing_rec DROP CONSTRAINT rec_id;
       public          postgres    false    206    2874    205            �      x�3�4�2bS 6������� ��      �   `   x�3�tN,*�/�2��/I,��2漰0#5�8�˄�)5��˔�?/3?�ˌ�=�('3�˜ӷ�8�(??��˂�-�8����(��� �%�+F��� ��<      �   <   x�3�t���IMQH�,��2��/-�2�H,.I�2�N�I,�2��
(�91z\\\ ë�      �   "   x�3����K�M�,I-.�442�2������ ��
�     