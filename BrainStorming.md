# FinComm Ecommerce Microservice
## Products

### Table products
- product_id
- product name
- product_price
- product_details
- product_isFragile
- timestamps(updatedAt ,deleted and createdAt)


### Table images
- image_id
- image_name
- image_desc
- image_url
- timestamps(updatedAt,deleted and createdAt)


### Table categories
- category_id
- category_name
- category_description
- timestamps(updatedAte,deleted and createdAt)

### Table ratings
- rate_id
- product_rate
- timestamps(updatedAt ,deleted and createdAt)


### Table videos
- video_id
- video_name
- video_desc
- video_url
- timestamps(updatedAt,deleted and createdAt)

### Table specifications
- specifications_id
- product_weight
- product_length
- product_width
- product_color
- timestamps(updatedAt ,deleted and createdAt)


### Table quantities
- quantity_id
- product_original_quantity
- product_current_quantity


### Table product_categories
- product_categories_id
- product_id
- category_id

### Table product_quantities
- product_quantity_id
- product_id
- quantity_id


### Table product_images
- product_images_id
- product_id
- image_id


### Table product_specifications
- product_specification_id
- product_id
- specifications_id



### Table product_rating
- product_rate_id
- rate_id
- product_id