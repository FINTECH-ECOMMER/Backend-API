IF OBJECT_ID(N'[dbo].[ASP_Seed_Data]', 'P') IS NOT NULL DROP PROCEDURE dbo.ASP_Seed_Data;
GO

CREATE PROCEDURE dbo.ASP_Seed_Data(@max INT=1001)
AS
BEGIN
  BEGIN TRY
    SET NOCOUNT ON;

    DECLARE @Counter INT=1;

    DELETE FROM dbo.product_specification;

    DELETE FROM dbo.product_video;

    DELETE FROM dbo.products;

    DELETE FROM dbo.videos;

    DELETE FROM dbo.specifications;

    DBCC CHECKIDENT('products', RESEED, 0);

    DBCC CHECKIDENT('specifications', RESEED, 0);

    DBCC CHECKIDENT('videos', RESEED, 0);

    WHILE(@Counter<=@max)
    BEGIN
      INSERT dbo.products(product_description, product_details, product_name, product_price)
      VALUES(NEWID(), NEWID(), LEFT(NEWID(), 5), RAND()* 1000000);

      INSERT dbo.specifications(product_length, product_weight, product_width, product_color)
      VALUES(RAND()* 1000, RAND()* 1000, RAND()* 1000, '#'+TRY_CAST(LEFT(NEWID(), 5) AS VARCHAR(5)));

      INSERT dbo.videos(video_desc, video_name, video_url)
      VALUES(NEWID(), LEFT(NEWID(), 5), 'http://www.'+LEFT(NEWID(), 5)+'.COM');

      INSERT dbo.product_specification(specification_id, product_id)VALUES(@Counter, @Counter);

      INSERT dbo.product_video(video_id, product_id)VALUES(@Counter, @Counter);

      SET @Counter=@Counter+1;
    END;
  END TRY
  BEGIN CATCH
    SELECT @Counter;
  END CATCH;
END;
GO

EXEC dbo.ASP_Seed_Data;
GO